# SimpleWeatherApp
A Spring Boot application that allows users to fetch weather forecasts for a specific city using the OpenWeatherMap API. The app provides a simple and user-friendly interface to display real-time weather information, such as temperature and weather descriptions, for any city around the world.

Features

Search Weather by City: Input a city name to fetch its 5-day weather forecast, including temperature and weather conditions.

Real-time Weather Data: Leverages the OpenWeatherMap API for updated weather information.

User-friendly Interface: Built using Spring MVC and Thymeleaf to provide a simple and responsive user experience.

Technology Stack

Spring Boot: Backend framework for building robust and scalable Java applications.

Thymeleaf: Templating engine for rendering dynamic HTML content.

RestTemplate: Used for making HTTP requests to the OpenWeatherMap API.

OpenWeatherMap API: Provides detailed and reliable weather data.

Setup Instructions

Prerequisites

Java 17 or higher

Maven

OpenWeatherMap API Key (Sign up for free at OpenWeatherMap)

Steps to Run the Application

Clone the Repository:

git clone https://github.com/yourusername/simple-weather-app.git
cd simple-weather-app

Add OpenWeatherMap API Key:

Create a file named application.properties in the src/main/resources directory.

Add the following content:

openweathermap.api.key=YOUR_API_KEY

Replace YOUR_API_KEY with your actual API key.

Build and Run:

./mvnw spring-boot:run

Access the Application:
Open your browser and visit http://localhost:8080.

Project Structure
