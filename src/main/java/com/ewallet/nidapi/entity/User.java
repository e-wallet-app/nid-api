package com.ewallet.nidapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "nid_users")
public class User {

    @Id
    @Column(name = "id")
    private String id;

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

    @Column(name = "national_id_number")
    private String nationalIdNumber;

    @Column(name = "old_national_id_number")
    private String oldNationalIdNumber;

    @Column(name = "photo_url")
    private String photoUrl;
}
