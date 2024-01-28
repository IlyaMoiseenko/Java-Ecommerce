package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.javaecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
