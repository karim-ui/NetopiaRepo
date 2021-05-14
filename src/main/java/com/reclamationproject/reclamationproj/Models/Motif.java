package com.reclamationproject.reclamationproj.Models;

import javax.persistence.*;

@Entity
@Table(name="ref_motif")
public class Motif {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long motif_id;
    private String motif_label;
    @Column(unique=true,length = 32)
    private String motif_code;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "motif_type")
    private MotifType motif_type;


    public Motif() {
    }

    public Motif(String motif_label, String motif_code,MotifType motifType) {
        this.motif_label = motif_label;
        this.motif_code = motif_code;
        this.motif_type=motifType;
    }

    public Long getMotif_id() {
        return motif_id;
    }

    public void setMotif_id(Long motif_id) {
        this.motif_id = motif_id;
    }

    public String getMotif_label() {
        return motif_label;
    }

    public void setMotif_label(String motif_label) {
        this.motif_label = motif_label;
    }

    public String getMotif_code() {
        return motif_code;
    }

    public void setMotif_code(String motif_code) {
        this.motif_code = motif_code;
    }

    public MotifType getMotifType() {
        return motif_type;
    }

    public void setMotifType(MotifType motifType) {
        this.motif_type = motifType;
    }
}
