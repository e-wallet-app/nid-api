package com.ewallet.nidapi.repository;

import com.ewallet.nidapi.entity.NidInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NidInfoRepository extends JpaRepository<NidInfo, String> {
    Optional<NidInfo> findByDateOfBirthAndNidNumber(String dateOfBirth, String nidNumber);
    Optional<NidInfo> findByFullNameAndDateOfBirthAndNidNumber(String fullName, String dateOfBirth, String nidNumber);
}
