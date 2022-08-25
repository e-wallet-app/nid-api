package com.ewallet.nidapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "nid_infos")
public class NidInfo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "present_address")
    private String presentAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "gender")
    private String gender;

    @Column(name = "profession")
    private String profession;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "nid_number")
    private String nidNumber;

    @Column(name = "old_nid_number")
    private String oldNidNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "photo_url")
    private String photoUrl;
}
