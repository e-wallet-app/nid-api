package com.ewallet.nidapi.dto.request;

import lombok.*;

@Data
public class NidInfoRequest {

    private String fullName;

    private String fatherName;

    private String motherName;

    private String spouseName;

    private String presentAddress;

    private String permanentAddress;

    private String gender;

    private String profession;

    private String dateOfBirth;

    private String nidNumber;

    private String oldNidNumber;

    private String phoneNumber;

    private String bloodGroup;

    private String photoUrl;
}
