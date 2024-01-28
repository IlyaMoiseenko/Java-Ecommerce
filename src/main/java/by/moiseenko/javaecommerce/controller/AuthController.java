package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.dto.request.AuthenticationRequest;
import by.moiseenko.javaecommerce.domain.dto.request.RegisterRequest;
import by.moiseenko.javaecommerce.domain.dto.response.AuthenticationResponse;
import by.moiseenko.javaecommerce.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
    }
}
