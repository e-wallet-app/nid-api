package com.ewallet.nidapi.controller;

import com.ewallet.nidapi.dto.request.KycNidRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.KycNidResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.service.NidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class NidController {

    @Autowired
    private NidInfoService nidInfoService;

    @PostMapping(value = "/add")
    public ResponseEntity<NidInfo> add(@RequestBody NidInfoRequest nidInfoRequest) {
        NidInfo nidInfo = nidInfoService.create(nidInfoRequest);
        return ResponseEntity.ok(nidInfo);
    }

    @PostMapping(value = "/kyc/nid-person")
    public ResponseEntity<KycNidResponse> kycNidPerson(@RequestBody KycNidRequest nidRequest) {
        KycNidResponse kycNidResponse = nidInfoService.kycNidPerson(nidRequest);
        return ResponseEntity.ok(kycNidResponse);
    }
}
