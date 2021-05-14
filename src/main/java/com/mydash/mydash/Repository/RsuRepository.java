package com.mydash.mydash.Repository;

import com.mydash.mydash.Models.RsuClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RsuRepository extends JpaRepository<RsuClient,Long> {

RsuClient findByIdcs(String s);
   // Optional<RsuClient> findRsuClientByPasswordAndIdcs(String password,String Idcs);
}
