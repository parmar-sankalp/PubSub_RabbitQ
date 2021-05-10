package com.example.merz.config;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MerzCarsUtils {

	 /**
     * Method to calculate fuel cost based on city
     **/
    @Cacheable(value = "fuelCostforCity", key = "#city")
    public Integer calFuelCostForCity(String city) {
    	Integer lidOpenTime = 150;   // Assume time taken between lid open and close was 150 seconds
    	Integer cityFuelCost;
    	Integer totalFuelFilled =  lidOpenTime / 30; //To calculate fuel in liters. The rate of fuel filling is 1 liter in 30 seconds
        switch (city) {
        case "Bangalore":
        	cityFuelCost = totalFuelFilled * 100; //Assume fuel price is 100 in Bangalore
            break;
        case "Sagar":
        	cityFuelCost = totalFuelFilled * 50;
            break;
        case "Damoh":
        	cityFuelCost = totalFuelFilled * 75;
            break;
        default:
        	cityFuelCost = 0;
        }
        System.out.println("MerzCarsUtils ::: city:"+city +" totalFuelFilled:"+totalFuelFilled + " " +"cityFuelCost:"+cityFuelCost);
        
    	return cityFuelCost;
    }
}
