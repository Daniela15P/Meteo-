package com.dani.meteo.service;

import com.dani.meteo.model.Meteo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MeteoService {

    private final String API_KEY = "1b8a8ca68274f765217f305006c5b0fa";

    public Meteo getMeteo(String city) throws Exception {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + API_KEY + "&units=metric&lang=it";

        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        JSONObject json = new JSONObject(response.toString());

        double temp = json.getJSONObject("main").getDouble("temp");
        String descrizione = json.getJSONArray("weather")
                .getJSONObject(0)
                .getString("description");


        return new Meteo(city, temp, descrizione);
    }
    public String getOpenMeteoData(double latitude, double longitude) throws Exception {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true&hourly=temperature_2m,relative_humidity_2m,precipitation,weathercode,pressure_msl,cloudcover,windspeed_10m,winddirection_10m&daily=temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,precipitation_hours,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant,shortwave_radiation_sum,weathercode&timezone=auto";

        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        // Restituisce la risposta JSON completa come stringa
        return response.toString();
    }
}
