package com.example.simple_weather_app;

public class Weather {
    private double temperature;
    private String description;

    public Weather(double temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }


    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}