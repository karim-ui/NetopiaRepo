package com.reclamationproject.reclamationproj.Repositories;

import com.reclamationproject.reclamationproj.Models.Motif;
import com.reclamationproject.reclamationproj.Models.MotifType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotifRepository extends JpaRepository<Motif,Long> {
   //  Optional<Motif> findByMotif_type(MotifType motifType);
    @Query("SELECT u FROM Motif  u WHERE u.motif_type = ?1 ")
    List<Motif> findmotifbytype(MotifType motifType);
    @Query("SELECT u FROM Motif  u WHERE u.motif_id = ?1 ")
    Motif findByid(Long id);



}
