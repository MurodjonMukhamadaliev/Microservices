package com.murodjon;

import com.murodjon.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public void send(NotificationRequest request) {
        repository.save(
                Notification.builder()
                        .toCustomerId(request.getToCustomerId())
                        .toCustomerEmail(request.getToCustomerName())
                        .sender("Murodjon")
                        .message(request.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }

}
