package org.rudra.eureka.customer.shared;

import org.rudra.eureka.event.Event;
import org.rudra.eureka.event.EventServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFeignClientFallback implements CustomerServiceFeignClient {

    public Customer getCustomer(int id) {
        return new Customer(12, "Fallback", "Customer");
    }

}
