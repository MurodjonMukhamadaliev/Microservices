package com.murodjon;

import com.murodjon.clients.customerState.CustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/state/")
public class CustomerStateController {
    private final CustomerStateService service;


    @GetMapping("/{customerId}")
    public CustomerResponse isSwindler(@PathVariable("customerId") Integer customerId) {
        boolean swindler = service.isSwindler(customerId);
        log.info("customer id, {}", customerId);
        return new CustomerResponse(swindler);
    }
}
