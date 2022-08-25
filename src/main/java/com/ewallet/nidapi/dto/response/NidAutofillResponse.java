package com.ewallet.nidapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NidAutofillResponse {

    private String fullName;

    private String fatherName;

    private String motherName;

    private String nidNumber;

    private String dateOfBirth;

    private String bloodGroup;

    private String presentAddress;

    private String photoUrl;
}
