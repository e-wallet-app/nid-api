package com.ewallet.nidapi.controller;

import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;
import com.ewallet.nidapi.service.NidInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NidControllerImpl implements NidController {

    private final NidInfoService nidInfoService;

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
