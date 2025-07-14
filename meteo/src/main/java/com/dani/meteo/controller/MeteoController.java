package com.dani.meteo.controller;

import com.dani.meteo.model.Meteo;
import com.dani.meteo.service.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meteo")
public class MeteoController {
    
    @Autowired
    private MeteoService meteoService;
    
    @GetMapping
    public Meteo getMeteo(@RequestParam String city) throws Exception {
        return meteoService.getMeteo(city);
    }
    @GetMapping("/openmeteo")
    public String getOpenMeteo(@RequestParam double lat, @RequestParam double lon) throws Exception {
        return meteoService.getOpenMeteoData(lat, lon);
    }
}





