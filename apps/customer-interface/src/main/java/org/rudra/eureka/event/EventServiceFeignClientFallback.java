package org.rudra.eureka.event;

import org.springframework.stereotype.Component;

@Component
public class EventServiceFeignClientFallback implements EventServiceFeignClient {

    public Event getEvent(int id) {
        return new Event(100,"Some Thing Interesting", "not yet decided","OutDoor");
    }

}
