package com.example.simple_weather_app;
import java.util.List;
public class OpenWeatherMapFindCityResponse {

    private List<OpenWeatherMapCity> list;

    public List<OpenWeatherMapCity> getList() {
        return list;
    }

    public void setList(List<OpenWeatherMapCity> list) {
        this.list = list;
    }
}