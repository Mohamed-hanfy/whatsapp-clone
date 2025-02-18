package com.mohamed.whatsappclone.intercepter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSynchronizer {
    public void synchornizeWithIdp(Jwt token) {

    }
}
