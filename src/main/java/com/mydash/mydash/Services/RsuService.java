package com.mydash.mydash.Services;

import com.mydash.mydash.Models.RsuClient;
import com.mydash.mydash.Models.UserData;
import org.springframework.stereotype.Service;

@Service
public interface RsuService {
    public void register(RsuClient rsuClient);
    public boolean checkIfUserExist(String email);
    public void saveRsuClient(RsuClient rsuClient);
}
