package com.mydash.mydash.security;
import com.mydash.mydash.Models.RsuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails{
    private RsuClient rsuClient;

    public UserPrincipal(RsuClient rsuClient)
    {
        this.rsuClient=rsuClient;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permissions (name)
        this.rsuClient.getPermissionList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        // Extract list of roles (ROLE_name)
        this.rsuClient.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.rsuClient.getPassword();
    }

    @Override
    public String getUsername() {
        return rsuClient.getIdcs();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getlelien()
    {
        return rsuClient.getLien();
    }

    public RsuClient getRsuClient() {
        return rsuClient;
    }

    public void setRsuClient(RsuClient rsuClient) {
        this.rsuClient = rsuClient;
    }
}
