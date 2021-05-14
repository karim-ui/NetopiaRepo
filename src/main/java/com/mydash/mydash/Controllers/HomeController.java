
package com.mydash.mydash.Controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydash.mydash.Models.RnpCitoyen;
import com.mydash.mydash.Models.RnpUserData;
import com.mydash.mydash.Models.RsuClient;
import com.mydash.mydash.Models.UserData;
import com.mydash.mydash.Services.RsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RsuService rsuService;
    @GetMapping("/registrationtwo")
    public  String registrationtwo(Model model,@ModelAttribute("RnpCitoyen") RnpCitoyen rnpCitoyen)
    {
       UserData userData =new UserData();
       userData.setIdcs(rnpCitoyen.getIdcs());
        model.addAttribute("UserData",userData);
        return "registrationtwo";
    }

    @GetMapping("/registrationone")
    public  String registrationone(Model model)
    {
        RnpUserData rnpUserData=new RnpUserData();
        model.addAttribute("rnpUserData",rnpUserData);
        return "registrationone";
    }
    @PostMapping("/registrationone")
    public  String checkrnp(@ModelAttribute RnpUserData rnpUserData, Model model, RedirectAttributes redirectAttributes)
    {


        String VerifyRnpUrl = "http://localhost:8085/rnp";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("-------------------- User Sent from form registrationone ---------------------------- \n"+
                "Idcs: "+rnpUserData.getIdcsRnp()+"\nDate: "+rnpUserData.getDateRnp()+"\nSex: "+rnpUserData.getSexRnp());

        HttpEntity<RnpUserData> request =
                new HttpEntity<>(rnpUserData, headers);

        RnpCitoyen rnpCitoyen=restTemplate.postForObject(VerifyRnpUrl, request, RnpCitoyen.class);
        if (rnpCitoyen!=null)
        {
            System.out.println("-------------------- User Returned by RNP ---------------------------- \n"+
                "Idcs: "+rnpCitoyen.getIdcs()+"\nDate: "+rnpCitoyen.getDate_naissance()+"\nSex: "+rnpCitoyen.getSex()+"\nville: "+rnpCitoyen.getVille());
            redirectAttributes.addFlashAttribute("RnpCitoyen", rnpCitoyen);
            model.addAttribute("RnpCitoyen",rnpCitoyen);
            return "redirect:registrationtwo";
        }
        else
            {
        System.out.println("User not found !!");
            redirectAttributes.addFlashAttribute("ErrorMessage", "VOUS N EXISTEZ PAS DANS LE RNP");
            return "redirect:registrationone?ErrorMessage";        }

    }
    @PostMapping("/registrationtwo")
    public  String addpassword(Model model)
    {
        return "";
    }
    @PostMapping("/registerrsu")
    public String registerrsu(@RequestParam(name="password") String password,@RequestParam(name="idcs") String idcs)
    {
        RsuClient rsuClient=new RsuClient(idcs,
                password,
                "chef menage",
                "USER",
                "");
rsuService.register(rsuClient);

        return "index";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}

