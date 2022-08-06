package com.murodjon;

import com.murodjon.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/notification")
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        log.info("new notification {}", request);
        service.send(request);

    }
}
