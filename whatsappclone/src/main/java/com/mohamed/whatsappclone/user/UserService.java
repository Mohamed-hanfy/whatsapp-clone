package com.mohamed.whatsappclone.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public List<UserResponse> getAllUsersExceptSelf(Authentication connectedUser){
        return userRepository.findAllUsersExceptSelf(connectedUser.getName())
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }
}
