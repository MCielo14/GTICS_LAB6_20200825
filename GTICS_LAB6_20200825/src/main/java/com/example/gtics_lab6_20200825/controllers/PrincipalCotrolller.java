package com.example.gtics_lab6_20200825.controllers;


import com.example.gtics_lab6_20200825.entity.Site;
import com.example.gtics_lab6_20200825.repository.LocacionRepository;
import com.example.gtics_lab6_20200825.repository.SitiosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Controller
public class PrincipalCotrolller {
    final SitiosRepository sitiosRepository;
    final LocacionRepository locacionRepository;


    public PrincipalCotrolller(SitiosRepository sitiosRepository,LocacionRepository locacionRepository ){
        this.sitiosRepository = sitiosRepository;
        this.locacionRepository= locacionRepository;

    }
    @GetMapping("/index")
    String index(){
        return "index";
    }
    @GetMapping("/sitios")
    String sitios(Model model){
        model.addAttribute("listasitios",sitiosRepository.findAll());
        return "sitios";
    }
    @GetMapping("/borrars")
    public String borrars(@RequestParam("id") int id, RedirectAttributes attributes) {

        Optional<Site> optional = sitiosRepository.findById(id);
        if (optional.isPresent()) {
            Site site = optional.get();
            String name = site.getSiteName();
            sitiosRepository.deleteById(id);
            attributes.addFlashAttribute("msg", "Sitio " + name + " borrado exitosamente");
        }
        return "redirect:/sitios";

    }

    @PostMapping("/saveSitio")
    public String saveSitio(RedirectAttributes attr, Model model, @RequestParam("siteName") String siteName, @RequestParam("locationID") int locationID, @RequestParam("installationDate") String installationDate, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude ) {

        String estado = "creado" ;
        attr.addFlashAttribute("msg", "Sitio " + estado + siteName + " correctamente");
        sitiosRepository.ingresodatos(siteName,locationID,installationDate,latitude,longitude);
        return "redirect:/sitios";
    }
    @GetMapping("/nuevositio")
    public String nuevositio(Model model) {
        model.addAttribute("listalocacion",locacionRepository.findAll());
        return "nuevoSitio";
    }



}
