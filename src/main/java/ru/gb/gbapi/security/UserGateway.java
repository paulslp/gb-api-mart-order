package ru.gb.gbapi.security;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserGateway {

    @GetMapping
    List<UserDto> getUserList();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<UserDto> handlePost(@Validated @RequestBody UserDto userDto);

    @PutMapping("/{id}")
    ResponseEntity<UserDto> handleUpdate(@PathVariable("id") Long id,
                                         @Validated @RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
