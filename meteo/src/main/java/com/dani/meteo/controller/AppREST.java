package com.dani.meteo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.dani.meteo.model.Citta;
import com.dani.meteo.service.MyService;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
// @CrossOrigin(origins= "*")
public class AppREST {
    
    @Autowired
    private MyService appService;

    @GetMapping("meteo")
        
    public ResponseEntity<?> getWeather(@RequestParam String citta) {
        
        try {
            return ResponseEntity.ok(appService.getMeteoPerCitta(citta));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        }

    }

    @GetMapping("citta")
    public ResponseEntity<List<Citta>> getCities() {
        return ResponseEntity.ok(appService.getCitta());
    }
    
    

}
