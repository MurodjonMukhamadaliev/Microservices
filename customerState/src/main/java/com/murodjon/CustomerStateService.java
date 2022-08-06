package com.murodjon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerStateService {
    private final CustomerStateRepository repository;

    public boolean isSwindler(Integer customerId) {
        repository.save(
                CustomerState.builder()
                        .customerId(customerId)
                        .isSwindler(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
