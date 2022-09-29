package com.ewallet.nidapi.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class NidInfoRequest {

    @NotBlank(message = "Full name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must be in alphabetic")
    private String fullName;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must be in alphabetic")
    private String fatherName;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must be in alphabetic")
    private String motherName;

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must be in alphabetic")
    private String spouseName;

    @NotBlank(message = "Present address is required")
    private String presentAddress;

    private String permanentAddress;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(?i)(Male|Female|Other)$", message = "Gender must be male, female or other")
    private String gender;

    private String profession;

    @NotBlank(message = "Date of birth is required")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-(19|20)\\d\\d$", message = "Date of birth must be in (dd-MMM-yyyy) format")
    private String dateOfBirth;

    @NotBlank(message = "NID number is required")
    @Pattern(regexp = "^[0-9]{10,17}$", message = "NID number must be 10 to 17 digit")
    private String nidNumber;

    @Pattern(regexp = "^[0-9]{17}$", message = "Old NID number must be 17 digit")
    private String oldNidNumber;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(88)?(01)([0-9]{9})$", message = "Phone number must be 11 digit")
    private String phoneNumber;

    @NotBlank(message = "Blood Group is required")
    @Pattern(regexp = "^(?i)(A|B|AB|O)[+-]$", message = "Blood group must be A+, A-, B+, B-, AB+, AB-, O+, O-")
    private String bloodGroup;

    @Pattern(regexp = "^(http|https)://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,3}(/\\S*)?$", message = "Invalid url")
    private String photoUrl;
}
