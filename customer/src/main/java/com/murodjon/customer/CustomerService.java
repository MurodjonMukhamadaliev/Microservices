package com.murodjon.customer;

import com.murodjon.clients.customerState.CustomerClient;
import com.murodjon.clients.customerState.CustomerResponse;
import com.murodjon.clients.notification.NotificationClient;
import com.murodjon.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final CustomerClient customerClient;
    private final NotificationClient notificationClient;

    public void register(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        Customer save = customerRepository.save(customer);

        CustomerResponse response = customerClient.isSwindler(save.getId());

        if (response.getIsSwindler()) {
            throw new IllegalStateException("Swindler");
        }

        notificationClient.sendNotification(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Welcome", customer.getFirstName())
        ));
    }

}
