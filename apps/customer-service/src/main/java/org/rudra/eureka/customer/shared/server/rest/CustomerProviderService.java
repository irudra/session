package org.rudra.eureka.customer.shared.server.rest;

import org.rudra.eureka.customer.shared.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerProviderService {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private List<Customer> customers;

    public CustomerProviderService() {
        customers = new LinkedList<>();
        customers.add(new Customer(1, "Peter", "Test"));
        customers.add(new Customer(2, "Peter", "Test2"));
    }

    public Customer get(int id) {
        logger.info("reading customer with id " + id);

        Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == id).findFirst();
        return customer.get();
    }
}
