package com.ewallet.nidapi.controller;

import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.service.NidInfoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NidControllerImpl implements NidController {

    private final NidInfoServiceImpl nidInfoService;

    public NidControllerImpl(NidInfoServiceImpl nidInfoService) {
        this.nidInfoService = nidInfoService;
    }

    @Override
    public ResponseEntity<NidInfo> add(NidInfoRequest nidInfoRequest) {
        var nidInfo = nidInfoService.create(nidInfoRequest);
        return ResponseEntity.ok(nidInfo);
    }

    @Override
    public ResponseEntity<List<NidInfoResponse>> list() {
        var nidInfoList = nidInfoService.getAll();
        return ResponseEntity.ok(nidInfoList);
    }

    @Override
    public ResponseEntity<NidVerifyResponse> verify(NidVerifyRequest nidRequest) {
        var kycNidResponse = nidInfoService.nidVerify(nidRequest);
        return ResponseEntity.ok(kycNidResponse);
    }

    @Override
    public ResponseEntity<NidAutofillResponse> autofill(NidAutofillRequest nidRequest) {
        var nidResponse = nidInfoService.nidAutofill(nidRequest);
        return ResponseEntity.ok(nidResponse);
    }
}
