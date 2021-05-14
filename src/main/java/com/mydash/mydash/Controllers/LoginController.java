package com.mydash.mydash.Controllers;

import com.mydash.mydash.Models.RsuClient;
import com.mydash.mydash.Services.RsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
   /* @Autowired
    private RsuService rsuService;
*/
   /* @PostMapping("/checkrsu")
    public String CheckIdcs(@ModelAttribute RsuClient rsuClient, Model model) {
        if (rsuService.CheckRsuClient(rsuClient))
            return "index";
        else return "login";
    }*/
    /*@PostMapping("/confirmIdcs")
    public String ConfirmIdcs()
    {
        return "index";
    }*/
}
