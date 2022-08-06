package com.murodjon.clients.customerState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "state",
        path= "/api/state"
)
public interface CustomerClient {


    @GetMapping( "/{customerId}")
    CustomerResponse isSwindler(@PathVariable("customerId") Integer customerId);
}
