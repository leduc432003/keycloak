package com.duc.keycloakauthservice.service;

import com.duc.keycloakauthservice.model.NewUserRecord;

public interface UserService {
    void createUser(NewUserRecord newUserRecord);
    void sendVerificationEmail(String userId);
}
