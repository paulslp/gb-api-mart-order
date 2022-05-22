package ru.gb.gbapi.security;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

public interface AuthGateway {

    @PostMapping("/{login}")
    ResponseEntity<HashMap<String, String>> login(
            @Validated @RequestBody AuthenticationUserDto authenticationUserDto
    );
}
