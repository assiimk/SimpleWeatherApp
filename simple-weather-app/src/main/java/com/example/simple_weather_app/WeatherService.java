package com.example.simple_weather_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";
    private static final String FIND_CITY_BASE_URL = "https://api.openweathermap.org/data/2.5/find";


    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<Forecast> getForecast(String cityName) {
        String findCityUrl = String.format("%s?q=%s&appid=%s", FIND_CITY_BASE_URL, cityName, apiKey);
        OpenWeatherMapFindCityResponse findCityResponse = restTemplate.getForObject(findCityUrl, OpenWeatherMapFindCityResponse.class);

        if(findCityResponse == null || findCityResponse.getList() == null || findCityResponse.getList().isEmpty()) {
            return null;
        }
        Integer cityId = findCityResponse.getList().get(0).getId();

        String url = String.format("%s?id=%s&appid=%s&units=metric", BASE_URL, cityId, apiKey);
        OpenWeatherMapResponse response = restTemplate.getForObject(url, OpenWeatherMapResponse.class);


        if (response == null || response.getList() == null || response.getList().isEmpty()) {
            return null;
        }


        List<Forecast> forecasts = new ArrayList<>();
        for (Map<String, Object> forecastData : response.getList()) {
            Map<String, Double> main = (Map<String, Double>) forecastData.get("main");
            List<Map<String, String>> weather = (List<Map<String, String>>) forecastData.get("weather");
            String dateTime = (String) forecastData.get("dt_txt");

            if (main != null && weather != null && !weather.isEmpty()) {
                double temperature = main.get("temp");
                String description = weather.get(0).get("description");
                Forecast forecast = new Forecast(temperature, description, dateTime);
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }
}