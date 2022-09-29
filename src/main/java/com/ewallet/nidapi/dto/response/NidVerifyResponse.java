package com.ewallet.nidapi.dto.response;

import lombok.Data;
import lombok.NonNull;

@Data
public class NidVerifyResponse {

    @NonNull
    private String status;

    @NonNull
    private String message;
}
