package org.rudra.eureka.event;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;

@Component
public class EventProviderService {

    private static Logger logger = LoggerFactory.getLogger(EventProviderService.class);

    @Autowired
    private EventDao eventDao;

    public Event get(int id) {
        logger.debug("reading customer with id " + id);
        Optional<Event> event = Optional.of(eventDao.get(id));
        return event.orElseThrow(this.exceptionSupplier(id));
    }

    private Supplier<HystrixBadRequestException> exceptionSupplier(int id) {
        return () -> new HystrixBadRequestException("Event not Found with id " + id);
    }

}
