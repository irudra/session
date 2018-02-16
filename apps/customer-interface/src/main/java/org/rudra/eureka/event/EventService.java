package org.rudra.eureka.event;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface EventService {

    @RequestMapping(value = "/app/event/id/{id}", method = RequestMethod.GET, produces = "application/json")
    Event getEvent(@PathVariable("id") int id);
}