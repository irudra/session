package org.rudra.eureka.event;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Supplier;

@RestController
@RequestMapping(value ="app")
public class EventController{

    private static Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventProviderService eventService;

    @RequestMapping(value="/event/id/{id}", method = RequestMethod.GET, produces = "application/json")
    @HystrixCommand(fallbackMethod = "fallbackGetEvent")
    public Event getEvent(@PathVariable int id) {

        logger.debug("reading customer with id " + id);
        return eventService.get(id);
    }

    public Event fallbackGetEvent(int id){
        return new Event(100, "Fall back event not existing event", "Uttarakhand", "OutDoor");
    }
}