/*

package com.reclamationproject.reclamationproj.DbInitialiser;


import com.reclamationproject.reclamationproj.Models.Motif;
import com.reclamationproject.reclamationproj.Models.MotifType;
import com.reclamationproject.reclamationproj.Repositories.MotifRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class dbinit implements CommandLineRunner {

    private  MotifRepository motifRepository;

    public dbinit(MotifRepository motifRepository) {
        this.motifRepository=motifRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.motifRepository.deleteAll();
        // Crete users
        Motif motifun = new Motif("ceci est un premier motif","motif1", MotifType.RECLAMATION);
        Motif motifdeux = new Motif("ceci est un deuxieme motif","motif2",MotifType.RADIATION);
        Motif motiftrois = new Motif("ceci est un troisieme motif","motif3",MotifType.RECLAMATION);
        Motif motifquatre = new Motif("ceci est un quatrieme motif","motif4",MotifType.RADIATION);



        List<Motif> motifs = Arrays.asList(motifun,motifdeux,motiftrois,motifquatre);

        // Save to db
        this.motifRepository.saveAll(motifs);
    }
}



*/
