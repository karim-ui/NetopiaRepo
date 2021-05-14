package com.mydash.mydash.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class RnpUserData implements Serializable {

    @NotBlank(message = "champ Idcs est obligatoire !!")
    @Id
    @Size(min = 4, max = 4, message
            = "votre idcs doit se composer de 4 characteres")
    private String idcsRnp;
    @NotBlank(message = "champ date est obligatoire !!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateRnp;
    @NotBlank(message = "champ sex est obligatoire !!")
    private String sexRnp;

    public RnpUserData(String idcsRnp, Date dateRnp, String sexRnp) {
        this.idcsRnp = idcsRnp;
        this.dateRnp = dateRnp;
        this.sexRnp = sexRnp;
    }

    public RnpUserData() {
    }

    public String getIdcsRnp() {
        return idcsRnp;
    }

    public void setIdcsRnp(String idcsRnp) {
        this.idcsRnp = idcsRnp;
    }

    public Date getDateRnp() {
        return dateRnp;
    }

    public void setDateRnp(Date dateRnp) {
        this.dateRnp = dateRnp;
    }

    public String getSexRnp() {
        return sexRnp;
    }

    public void setSexRnp(String sexRnp) {
        this.sexRnp = sexRnp;
    }
}
