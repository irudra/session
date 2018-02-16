package org.rudra.eureka.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventDao {

    private static Logger logger = LoggerFactory.getLogger(EventDao.class);

    private Map<Integer, Event> events;

    public EventDao() {
        events = new HashMap<>();
        events.put(1, new Event(1, "Run at Himalaya 2018", "Uttarakhand", "OutDoor"));
        events.put(2, new Event(2, "Sing with Ram Ganga Valley", "Uttarkhand", "Entertainment"));
    }

    public Event get(int id) {
        logger.debug("reading customer with id " + id);
        return events.get(id);
    }
}
