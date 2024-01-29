package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.javaecommerce.domain.dto.request.UserToUpdateRequest;
import by.moiseenko.javaecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/{userId}/address")
    public ResponseEntity<User> addAddress(@RequestBody @Valid AddressRequest request,
                                           @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(
                userService.addNewAddress(request, userId),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                userService.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(
                userService.getAll(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody @Valid UserToUpdateRequest request) {
        return new ResponseEntity<>(
                userService.update(id, request),
                HttpStatus.OK
        );
    }
}
