package com.ewallet.nidapi.controller;


import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/v1")
public interface NidController {

    @PostMapping(value = "/add")
    ResponseEntity<NidInfo> add(@RequestBody NidInfoRequest nidInfoRequest);

    @GetMapping(value = "/")
    ResponseEntity<List<NidInfoResponse>> list();

    @PostMapping(value = "/verify")
    ResponseEntity<NidVerifyResponse> verify(@RequestBody NidVerifyRequest nidRequest);

    @PostMapping(value = "/autofill")
    ResponseEntity<NidAutofillResponse> autofill(@RequestBody NidAutofillRequest nidRequest);
}
