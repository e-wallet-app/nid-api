package com.ewallet.nidapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NidAutofillRequest {

    private String nidNumber;

    private String dateOfBirth;
}