package com.ewallet.nidapi.repository;

import com.ewallet.nidapi.entity.NidInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NidRepository extends JpaRepository<NidInfo, String> {

}
