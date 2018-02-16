package org.rudra.hystrixeample.controller;

import org.rudra.hystrixeample.domain.Customer;
import org.rudra.hystrixeample.service.CustomerCacheService;
import org.rudra.hystrixeample.config.HystrixContextInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * @see HystrixContextInterceptor
 */
@RestController
@RequestMapping("/product")
class HystrixCacheController {

    @Autowired
    CustomerCacheService customerCacheService;

    @RequestMapping(value = "/customer-cache/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@PathVariable int id, @RequestParam String name) throws ExecutionException, InterruptedException {
        return customerCacheService.createCustomer(id, name);
    }



}