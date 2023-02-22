package com.example.board.Password;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    public boolean checkPassword(String plainPassword, String storePassword) {
        return BCrypt.checkpw(plainPassword, storePassword);
    }
}
