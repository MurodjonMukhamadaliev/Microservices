package com.murodjon.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification"
)
public interface NotificationClient {
    @PostMapping("api/notification")
    public void sendNotification(NotificationRequest notificationRequest);
}
