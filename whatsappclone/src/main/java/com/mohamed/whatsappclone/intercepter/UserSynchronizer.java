package com.mohamed.whatsappclone.intercepter;

import com.mohamed.whatsappclone.user.User;
import com.mohamed.whatsappclone.user.UserMapper;
import com.mohamed.whatsappclone.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSynchronizer {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void synchornizeWithIdp(Jwt token) {
    log.info("synchornizeWithIdp");
    getUserEmail(token).ifPresent(userEmail -> {
        log.info("synchornizeWithIdp");
       Optional<User> optUser = userRepository.findByEmail(userEmail);
       User user = userMapper.fromTokenAttributes(token.getClaims());
       optUser.ifPresent(value ->user.setId(optUser.get().getId()));
       userRepository.save(user);
    });
    }

    private Optional<String> getUserEmail(Jwt token) {
        Map<String,Object> attributes = token.getClaims();
        if(attributes.containsKey("email")) {
            return Optional.ofNullable((String) attributes.get("email"));
        }
        return Optional.empty();
    }
}
