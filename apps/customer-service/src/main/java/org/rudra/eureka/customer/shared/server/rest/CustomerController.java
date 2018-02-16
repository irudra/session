package org.rudra.eureka.customer.shared.server.rest;


import org.rudra.eureka.customer.shared.Customer;
import org.rudra.eureka.customer.shared.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/app")
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private List<Customer> customers;

    public CustomerController() {
        customers = new LinkedList<>();
        customers.add(new Customer(1, "Peter", "Test"));
        customers.add(new Customer(2, "Peter", "Test2"));
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@PathVariable int id) {

        logger.info("reading customer with id " + id);

        Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == id).findFirst();

        return customer.get();

    }

}