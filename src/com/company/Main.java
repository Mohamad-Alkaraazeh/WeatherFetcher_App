package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        WeatherFetcher w = WeatherFetcher.getInstance();

        Scanner scanner= new Scanner(System.in);
        System.out.println("For which city do you want to see the weather?");
        String input= scanner.next();

        WeatherInfo[] weatherInfos = w.fetch(input);

        for(int x = 0; x <weatherInfos.length; x++){
            WeatherInfo weatherinfo = weatherInfos[x];
            System.out.println("Time is: " + weatherinfo.getTimestamp() +
                                ", temperature: " + weatherinfo.getTemperature() +
                                ", humidity: " + weatherinfo.getHumidity() +
                                ", WindSpeed: " + weatherinfo.getWindSpeed()+
                                 ", Clouds: " + weatherinfo.getClouds()  );
        }
    }
}
