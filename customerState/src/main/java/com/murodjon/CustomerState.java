package com.murodjon;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CustomerState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer customerId;
    Boolean isSwindler;
    LocalDateTime createdAt;


}
