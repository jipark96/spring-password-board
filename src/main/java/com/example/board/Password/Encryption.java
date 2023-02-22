package com.example.board.Password;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Encryption {

    public String hashingPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
