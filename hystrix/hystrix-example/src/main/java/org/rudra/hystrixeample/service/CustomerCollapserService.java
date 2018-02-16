package org.rudra.hystrixeample.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.rudra.hystrixeample.domain.Customer;
import org.rudra.hystrixeample.domain.MessageWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

@Service
public class CustomerCollapserService {

    // timerDelayInMilliseconds is set only for testing purposes
    @HystrixCollapser(scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, batchMethod = "getCustomerByIds", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "2000")
    })
    public Future<MessageWrapper> getCustomerById(Integer id) {
        throw new RuntimeException("This method body should not be executed");
    }

    @HystrixCommand
    public List<MessageWrapper> getCustomerByIds(List<Integer> ids) {

        List<MessageWrapper> customers = new ArrayList<>(ids.size());

        String message = "Batched calls with IDs " + Objects.toString(ids);

        for (Integer id : ids) {
            customers.add(new MessageWrapper<>(new Customer(id, "First", "Last"), message));
        }

        return customers;

    }

}
