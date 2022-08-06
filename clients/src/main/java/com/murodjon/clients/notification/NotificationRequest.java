package com.murodjon.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationRequest {
    Integer toCustomerId;
    String toCustomerName;
    String message;
}
