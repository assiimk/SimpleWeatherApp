package com.example.simple_weather_app;

public class Forecast {
    private double temperature;
    private String description;
    private String dateTime;

    public Forecast(double temperature, String description, String dateTime) {
        this.temperature = temperature;
        this.description = description;
        this.dateTime = dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }
}