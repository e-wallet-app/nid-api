package com.ewallet.nidapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class NidAutofillRequest {
    @NotBlank(message = "NID number is required")
    @Pattern(regexp = "^[0-9]{10,17}$", message = "NID number must be 10 to 17 digit")
    private String nidNumber;

    @NotBlank(message = "Date of birth is required")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-(19|20)\\d\\d$", message = "Date of birth must be in (dd-MMM-yyyy) format")
    private String dateOfBirth;
}
