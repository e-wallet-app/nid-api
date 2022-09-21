package com.ewallet.nidapi.dto.request;

import lombok.Data;

@Data
public class NidAutofillRequest {

    private String nidNumber;

    private String dateOfBirth;
}
