/*
package com.mydash.mydash.Models;

import com.mydash.mydash.Repository.RsuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private RsuRepository rsuRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(RsuRepository userRepository, PasswordEncoder passwordEncoder) {
        this.rsuRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.rsuRepository.deleteAll();
        // Crete users
        RsuClient imghi = new RsuClient("netopia12",passwordEncoder.encode("netopia"),"chef menage","USER","");
        RsuClient wakrim = new RsuClient("abdo12",passwordEncoder.encode("123456"),"chef menage","ADMIN","");


        List<RsuClient> users = Arrays.asList(imghi,wakrim);

        // Save to db
        this.rsuRepository.saveAll(users);
    }
}
*/
