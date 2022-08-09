package com.ewallet.nidapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KycNidRequest {
    private String fullName;
    private String nidNumber;
    private String dateOfBirth;
    private boolean matchName;
}
