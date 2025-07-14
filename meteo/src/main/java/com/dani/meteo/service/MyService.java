package com.dani.meteo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dani.meteo.model.Citta;
import com.dani.meteo.repo.CittaRepo;

@Service
public class MyService {
    
    @Autowired
    private CittaRepo repoCitta;

    private final RestTemplate restTemplate= new RestTemplate();

    public List<Citta> getCitta() {
        return repoCitta.findAll();
    };

    public Map<String, Object> getMeteoPerCitta(String citta){
        Citta c = repoCitta.findByNome(citta).orElseThrow(()->new RuntimeException("città non trovata"));
        
        double lat = c.getLatitudine();
        double lon = c.getLongitudine();

        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=temperature_2m", lat, lon);

        Map<String, Object> apiResponse = restTemplate.getForObject(url, Map.class);
        Map<String, Object> hourly = (Map<String, Object>) apiResponse.get("hourly");

        Map<String, Object> filtered = new HashMap<>();

        filtered.put("time", hourly.get("time"));
        filtered.put("temperature", hourly.get("temperature_2m"));

        return filtered;
    };

}
