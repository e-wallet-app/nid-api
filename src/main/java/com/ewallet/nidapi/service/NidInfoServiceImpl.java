package com.ewallet.nidapi.service;

import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.repository.NidInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NidInfoServiceImpl implements NidInfoService{

    private final NidInfoRepository nidRepository;

    public NidInfoServiceImpl(NidInfoRepository nidRepository) {
        this.nidRepository = nidRepository;
    }

    @Override
    public NidInfo create(NidInfoRequest nidInfoRequest) {
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

        NidInfo nidInfo;
        if(matchName)
            nidInfo = nidRepository.findByFullNameAndDateOfBirthAndNidNumber(fullName, dateOfBirth, nidNumber).orElse(null);
        else
            nidInfo = nidRepository.findByDateOfBirthAndNidNumber(dateOfBirth, nidNumber).orElse(null);

        if (nidInfo != null) {
            return new NidVerifyResponse("200", "NID information Found.");
        } else {
            return new NidVerifyResponse("404", "NID information Not Found.");//dynamically send the field name
        }
    }

    @Override
    public NidAutofillResponse nidAutofill(NidAutofillRequest nidAutofillRequest){
        String nidNumber = nidAutofillRequest.getNidNumber();
        String dateOfBirth = nidAutofillRequest.getDateOfBirth();

        NidInfo nidInfo = nidRepository.findByDateOfBirthAndNidNumber(dateOfBirth, nidNumber).orElse(null);

        NidAutofillResponse nidResponse = new NidAutofillResponse();
        if(nidInfo != null) {
            BeanUtils.copyProperties(nidInfo, nidResponse);
        }

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
