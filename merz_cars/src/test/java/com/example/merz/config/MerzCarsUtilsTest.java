package com.example.merz.config;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.merz.MerzCarsApplication;

@SpringBootTest(classes = MerzCarsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class MerzCarsUtilsTest {

    @Autowired
    private MerzCarsUtils merzCarsUtils;

    
    /**
     * method to verify the fuel cost for a valid city
     * @throws Exception
     */
    @Test
    public void getFuelCostForValidCity() throws Exception {
        String city = "Damoh";
        Integer fuelCost = merzCarsUtils.calFuelCostForCity(city);
        assertTrue(fuelCost != 0);
    }
    
    
    /**
     * method to verify the fuel cost for invalid city
     * @throws Exception
     */
    @Test
    public void getFuelCostForInvalidCity() throws Exception {
        String city = "Bern";
        Integer fuelCost = merzCarsUtils.calFuelCostForCity(city);
        assertTrue(fuelCost == 0);
    }

}
