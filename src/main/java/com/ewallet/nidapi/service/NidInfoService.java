package com.ewallet.nidapi.service;

import com.ewallet.nidapi.dto.request.NidVerifyRequest;
import com.ewallet.nidapi.dto.request.NidAutofillRequest;
import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.dto.response.NidVerifyResponse;
import com.ewallet.nidapi.dto.response.NidAutofillResponse;
import com.ewallet.nidapi.dto.response.NidInfoResponse;
import com.ewallet.nidapi.entity.NidInfo;

import java.util.List;

public interface NidInfoService {
    NidInfo create(NidInfoRequest nidInfoRequest);

    NidVerifyResponse nidVerify(NidVerifyRequest nidVerifyRequest);

    NidAutofillResponse nidAutofill(NidAutofillRequest nidAutofillRequest);

    List<NidInfoResponse> getAll();
}
