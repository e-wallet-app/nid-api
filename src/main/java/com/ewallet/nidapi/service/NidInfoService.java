package com.ewallet.nidapi.service;

import com.ewallet.nidapi.dto.request.KycNidRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.KycNidResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.repository.NidInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NidInfoService {

    private final NidInfoRepository nidRepository;

    public NidInfoService(NidInfoRepository nidRepository) {
        this.nidRepository = nidRepository;
    }

    public NidInfo create(NidInfoRequest nidInfoRequest) {
        NidInfo nidInfo = new NidInfo();
        BeanUtils.copyProperties(nidInfoRequest, nidInfo);
        return nidRepository.save(nidInfo);
    }

    public KycNidResponse kycNidPerson(KycNidRequest kycNidRequest) {
        String fullName = kycNidRequest.getFullName();
        String nidNumber = kycNidRequest.getNidNumber();
        String dateOfBirth = kycNidRequest.getDateOfBirth();
        boolean matchName = kycNidRequest.isMatchName();

        NidInfo nidInfo;
        if(matchName)
            nidInfo = nidRepository.findByFullNameAndDateOfBirthAndNidNumber(fullName, dateOfBirth, nidNumber).orElse(null);
        else
            nidInfo = nidRepository.findByDateOfBirthAndNidNumber(dateOfBirth, nidNumber).orElse(null);

        if (nidInfo != null) {
            return new KycNidResponse("200", "NID information Found.");
        } else {
            return new KycNidResponse("404", "NID information Not Found.");//dynamically send the field name
        }
    }

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
}
