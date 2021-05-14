package com.reclamationproject.reclamationproj.Api;
import com.reclamationproject.reclamationproj.Models.Motif;
import com.reclamationproject.reclamationproj.Models.MotifType;
import com.reclamationproject.reclamationproj.Repositories.MotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
public class MotifApi {
    ///////// ///////// ///////// /////////  fields and constructors ///////// ///////// ///////// /////////
    private final MotifRepository motifRepository;
    public MotifApi(MotifRepository motifRepository) {
        this.motifRepository = motifRepository;
    }




    ///////// ///////// ///////// ///////// get request to all motifs   ///////// ///////// ///////// /////////
    @GetMapping("/motifs")
    public List<Motif> getAllMotifs() {
        return motifRepository.findAll();
    }





    /////////// ///////// //////////////////  Get request to  motifs by type   ///////// ///////// ///////// /////////
    @GetMapping("/motifs/typemotif/{motif_type}")
    public ResponseEntity<List<Motif>> getMotifsByType(@PathVariable(value = "motif_type") MotifType motif_type)
    {
        try {
            List<Motif> motifs =
                    motifRepository
                            .findmotifbytype(motif_type);
            return ResponseEntity.ok().body(motifs);

        } catch (Exception e) {
            System.out.println("motif not found with this type:"+motif_type);
                     return null;
        }
    }




      /////////// ///////// ///////// ///////// Post request to add motifs  ///////// ///////// ///////// /////////
    @PostMapping("/motifs")
    public Motif createMotif( @RequestBody @Valid Motif motif) {
        return motifRepository.save(motif);
    }



    // ///////// ///////// ///////// ///////// put motifs to update motifs  ///////// ///////// ///////// /////////
    @PutMapping("/motifs/{motif_id}")
    public ResponseEntity<Motif> updateMotif(
            @PathVariable(value = "motif_id") Long motif_id, @Valid @RequestBody Motif motif)
            throws ResourceNotFoundException {

        Motif mymotif =
                motifRepository
                        .findById(motif_id)
                        .orElseThrow(() -> new ResourceNotFoundException("Motif not found on :: " + motif_id));

        mymotif.setMotif_code(motif.getMotif_code());
        mymotif.setMotif_label(motif.getMotif_label());
        mymotif.setMotifType(motif.getMotifType());
        final Motif updatedmotif = motifRepository.save(mymotif);
        return ResponseEntity.ok(updatedmotif);
    }




    /////////// ///////// ///////// /////////  Get request to  motifs by id  ///////// ///////// ///////// /////////
    @GetMapping("/motifs/idmotif/{motif_id}")
    public ResponseEntity<Motif> getMotifsById(@PathVariable(value = "motif_id") Long motif_id)
            throws ResourceNotFoundException {

        Motif motif =
                motifRepository
                 .findById(motif_id)
                .orElseThrow(() -> new ResourceNotFoundException("Motif not found on :: " + motif_id));

            return ResponseEntity.ok().body(motif);

    }



    /////////// ///////// ///////// /////////  Delete request of motifs  ///////// ///////// ///////// /////////
    @DeleteMapping("/motifs/{motif_id}")
    public Map<String, Boolean> deleteMotif(@PathVariable(value = "motif_id") Long motif_id) throws ResourceNotFoundException {
        Motif motif =
                motifRepository
                        .findById(motif_id)
                        .orElseThrow(() -> new ResourceNotFoundException("Motif not found on :: " + motif_id));

        motifRepository.delete(motif);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
