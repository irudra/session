package org.rudra.eureka.event;

import org.rudra.eureka.customer.shared.CustomerServiceFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "customer-service", fallback = EventServiceFeignClientFallback.class)
public interface EventServiceFeignClient extends EventService {

}
