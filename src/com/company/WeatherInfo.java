package com.company;

public class WeatherInfo {

    private String timestamp;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String clouds;

    WeatherInfo (String timestamp, String temperature, String humidity, String windSpeed, String clouds){
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getTemperature(){
        return temperature;
    }

    public String getHumidity(){
        return humidity;
    }

    public String getWindSpeed(){
        return windSpeed;
    }

    public String getClouds(){
        return clouds;
    }
}
