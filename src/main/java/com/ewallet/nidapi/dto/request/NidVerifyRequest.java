package com.ewallet.nidapi.dto.request;

import lombok.Data;
@Data
public class NidVerifyRequest {

    private String fullName;

    private String nidNumber;

    private String dateOfBirth;

    private boolean matchName;
}
