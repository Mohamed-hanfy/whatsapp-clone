package com.mohamed.whatsappclone.user;

import lombok.*;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastSeen;
    private boolean isOnline;

}
