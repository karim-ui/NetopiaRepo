package com.mydash.mydash.Models;

import javax.validation.constraints.*;
import java.io.Serializable;

public class UserData implements Serializable {

    @NotEmpty(message = "idcs ne doit pas etre vide")
    private String idcs;
    @Size(min = 6, max = 12, message
            = "minimum des characteres est 6 , maximum est 12")
    @NotEmpty(message = "password ne doit pas etre vide")
    private String password;

    public UserData() {
    }

    public UserData(@NotEmpty(message = "Idcs can not be empty") String idcs, @NotEmpty(message = "Password can not be empty") String password) {
        this.idcs = idcs;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcs() {
        return idcs;
    }

    public void setIdcs(String idcs) {
        this.idcs = idcs;
    }



}
