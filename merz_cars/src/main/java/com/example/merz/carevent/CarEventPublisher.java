package com.example.merz.carevent;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.merz.config.MessagingConfig;
import com.example.merz.dto.CarEvent;

@RestController
@RequestMapping("/v1/fuel")
public class CarEventPublisher {

    @Autowired
    private RabbitTemplate template;
    
    private String vin = "1234ABC";
    private Boolean fuelLid = true;
    private String city = "Damoh";

    /**
     * Method to publish events via REST API
     **/
    @PostMapping("/getFuelCost")
    public String sendCarEvent(@RequestBody CarEvent carEvent) {    	  	
       template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, carEvent);
        System.out.println("Publish Car Event Manually:"+carEvent.toString());
        return "Success !!";
    }
    
    /**
     * Method to publish events via scheduler in every 5 secs
     **/
    @Scheduled(fixedDelay = 5000)
    public String publishCarEvent() {
    	CarEvent carEvent = new CarEvent(vin, fuelLid, city);    	
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, carEvent);    	
        System.out.println("Publish Car Event via Schedular :"+carEvent.toString());
        return "Successfully Triggered !!";
    }
    
    
    
}
