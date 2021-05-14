package com.mydash.mydash.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class RsuClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String idcs;
    @Column(nullable = false)
    private String password;
    private String lien;
    @Column(unique = true)
    private String roles = "";
    private String permissions = "";



    public String getRoles() {
        return roles;
    }
    public String getPermissions() {
        return permissions;
    }
    public RsuClient(String idcs, String password,String lien,String roles,String permissions) {
        this.idcs = idcs;
        this.password = password;
        this.lien = lien;
        this.roles=roles;
        this.permissions=permissions;
    }
    public RsuClient()
    {
    }
    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }


    public long getId() {
        return id;
    }


    public String getIdcs() {
        return idcs;
    }

    public void setIdcs(String idcs) {
        this.idcs = idcs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}