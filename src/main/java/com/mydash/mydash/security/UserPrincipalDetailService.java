package com.mydash.mydash.security;

import com.mydash.mydash.Models.RsuClient;
import com.mydash.mydash.Repository.RsuRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService {
   private RsuRepository rsuRepository;

    public UserPrincipalDetailService(RsuRepository rsuRepository) {
        this.rsuRepository = rsuRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RsuClient rsuClient=rsuRepository.findByIdcs(s);
        UserPrincipal userPrincipal= new UserPrincipal(rsuClient);
        return userPrincipal;
    }
}
