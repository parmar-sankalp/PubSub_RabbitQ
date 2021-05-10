package com.example.merz.costcal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.merz.config.MerzCarsUtils;
import com.example.merz.config.MessagingConfig;
import com.example.merz.dto.CarEvent;

@Component
public class FuelCostCalConsumer {

	@Autowired
	private FuelCostCalConsumer fuelCostCalConsumer;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	MerzCarsUtils merzCarsUtils;
	
	/**
     * Consumer method to pull message sent from carEventPublisher 
     **/
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(CarEvent carEvent) {
		String vin = carEvent.vin;
		Boolean fuelLid = carEvent.fuelLid;
		String city = carEvent.city;
		Integer fuelCost = 0;
		System.out.println("Car event recieved for vin: " + vin + " fuelLid:" + fuelLid + " city:" + city);
		if (fuelLid) {			
			  fuelCost =merzCarsUtils.calFuelCostForCity(city);			 
			// fuelCost = fuelCostCalConsumer.fuelCostforCity(city);
		}
		System.out.println("Total fule cost: " + fuelCost);
	}

	/**
     * Method to clear cache in every 20 seconds
     **/
	@Scheduled(fixedRate = 20000)
	public void evictAllcachesAtIntervals() {
		evictAllCacheValues("fuelCostforCity");
	}

	public void evictAllCacheValues(String cacheName) {
		cacheManager.getCache(cacheName).clear();
	}

}
