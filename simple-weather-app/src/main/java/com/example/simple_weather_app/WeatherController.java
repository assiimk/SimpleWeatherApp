package com.example.simple_weather_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cityName","");
        return "forecast";
    }


    @GetMapping("/forecast")
    public String getForecast(@RequestParam(name = "cityName", required = false) String cityName, Model model) {
        List<Forecast> forecasts = null;
        if(cityName != null && !cityName.isEmpty()){
            forecasts = weatherService.getForecast(cityName);
        }


        model.addAttribute("cityName",cityName);
        model.addAttribute("forecasts",forecasts);
        return "forecast";
    }
}