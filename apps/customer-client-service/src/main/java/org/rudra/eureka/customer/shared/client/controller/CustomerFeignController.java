package org.rudra.eureka.customer.shared.client.controller;

import org.rudra.eureka.customer.shared.Customer;
import org.rudra.eureka.customer.shared.CustomerServiceFeignClient;
import org.rudra.eureka.event.Event;
import org.rudra.eureka.event.EventServiceFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pub")
public class CustomerFeignController {

    private static Logger logger = LoggerFactory.getLogger(CustomerFeignController.class);

    @Autowired
    private CustomerServiceFeignClient customerServiceFeignClient;

    @Autowired
    private EventServiceFeignClient eventServiceFeignClient;

    @RequestMapping(value = "/customer-client-feign/{id}", method = RequestMethod.GET, produces = "application/json")
    public MessageWrapper<Customer> getCustomer(@PathVariable int id) {

        logger.debug("Reading customer using feign client with ID " + id);

        Customer customer = customerServiceFeignClient.getCustomer(id);

        return new MessageWrapper<>(customer, "server called using eureka with feign");
    }

    @RequestMapping(value = "/event-client-feign/{id}", method = RequestMethod.GET, produces = "application/json")
    public MessageWrapper<Event> getEvent(@PathVariable int id) {

        logger.debug("Reading event using feign client with ID " + id);

        Event customer = eventServiceFeignClient.getEvent(id);

        return new MessageWrapper<>(customer, "server called using eureka with feign");
    }

}