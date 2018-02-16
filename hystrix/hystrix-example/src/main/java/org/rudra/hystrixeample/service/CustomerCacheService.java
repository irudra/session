package org.rudra.hystrixeample.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.rudra.hystrixeample.config.HystrixContextInterceptor;
import org.rudra.hystrixeample.domain.Customer;
import org.springframework.stereotype.Service;


/**
 * @see HystrixContextInterceptor
 */
@Service
public class CustomerCacheService {

    @CacheResult
    @HystrixCommand
    public Customer createCustomer(@CacheKey int id, String name) {
        return new Customer(id, name, name);
    }

}
