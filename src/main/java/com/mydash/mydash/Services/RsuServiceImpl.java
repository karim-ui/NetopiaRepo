
package com.mydash.mydash.Services;

import com.mydash.mydash.Models.RsuClient;
import com.mydash.mydash.Models.UserData;
import com.mydash.mydash.Repository.RsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RsuServiceImpl implements RsuService{
    @Autowired
    private RsuRepository rsuRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(RsuClient rsuClient)
    {
        /*boolean userExists= rsuRepository
                .findByEmail(userData.getEmail())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("Email Already Taken");
        }

*/      rsuClient.setPassword(passwordEncoder.encode(rsuClient.getPassword()));

          rsuRepository.save(rsuClient);

    }

    @Override
    public void saveRsuClient(RsuClient rsuClient) {
        rsuRepository.save(rsuClient);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return false;
    }
    private void encodePassword(RsuClient rsuClient, UserData user){
        rsuClient.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

