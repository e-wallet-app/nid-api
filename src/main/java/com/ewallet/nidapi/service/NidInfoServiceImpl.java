package com.ewallet.nidapi.service;

import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.exeption.DuplicateEntryException;
import com.ewallet.nidapi.exeption.NotFoundException;
import com.ewallet.nidapi.repository.NidInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class NidInfoServiceImpl implements NidInfoService{

    private final NidInfoRepository nidRepository;

    @Override
    public NidInfo create(NidInfoRequest nidInfoRequest) {
        nidRepository.findByNidNumberOrOldNidNumberOrPhoneNumber(nidInfoRequest.getNidNumber(), nidInfoRequest.getOldNidNumber(), nidInfoRequest.getPhoneNumber())
            .ifPresent(entry -> {
                throw new DuplicateEntryException("User already exists");
            });
        NidInfo nidInfo = new NidInfo();
        BeanUtils.copyProperties(nidInfoRequest, nidInfo);
        return nidRepository.save(nidInfo);
    }

    @Override
    public NidVerifyResponse nidVerify(NidVerifyRequest nidVerifyRequest) {
        String fullName = nidVerifyRequest.getFullName();
        String nidNumber = nidVerifyRequest.getNidNumber();
        String dateOfBirth = nidVerifyRequest.getDateOfBirth();
        boolean matchName = nidVerifyRequest.isMatchName();

        if(matchName)
            nidRepository.findByFullNameAndDateOfBirthAndNidNumber(fullName, dateOfBirth, nidNumber).orElseThrow(() -> new NotFoundException("NID information Not Found"));
        else
            nidRepository.findByDateOfBirthAndNidNumber(dateOfBirth, nidNumber).orElseThrow(() -> new NotFoundException("NID information Not Found"));

        return new NidVerifyResponse(HttpStatus.OK.name(), "NID information found");

    }

    @Override
    public NidAutofillResponse nidAutofill(NidAutofillRequest nidAutofillRequest){
        String nidNumber = nidAutofillRequest.getNidNumber();
        String dateOfBirth = nidAutofillRequest.getDateOfBirth();

        NidInfo nidInfo = nidRepository.findByDateOfBirthAndNidNumber(dateOfBirth, nidNumber).orElseThrow(() -> new NotFoundException("NID information Not Found"));

        NidAutofillResponse nidResponse = new NidAutofillResponse();
        BeanUtils.copyProperties(nidInfo, nidResponse);

        return nidResponse;
    }

    @Override
    public List<NidInfoResponse> getAll() {
        List<NidInfo> nidInfoList = nidRepository.findAll();
        List<NidInfoResponse> nidInfoResponseList = new ArrayList<>();

        for (NidInfo nidInfo : nidInfoList) {
            NidInfoResponse nidInfoResponse = new NidInfoResponse();
            BeanUtils.copyProperties(nidInfo, nidInfoResponse);
            nidInfoResponseList.add(nidInfoResponse);
        }

        return nidInfoResponseList;
    }
}
