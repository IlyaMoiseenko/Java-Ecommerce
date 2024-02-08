package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.UserPrincipal;
import by.moiseenko.javaecommerce.domain.UserReview;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.javaecommerce.domain.dto.request.UserReviewRequest;
import by.moiseenko.javaecommerce.domain.dto.request.UserToUpdateRequest;
import by.moiseenko.javaecommerce.domain.dto.response.UserReviewResponse;
import by.moiseenko.javaecommerce.mapper.UserReviewMapper;
import by.moiseenko.javaecommerce.service.UserReviewService;
import by.moiseenko.javaecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserReviewMapper userReviewMapper;
    private final UserReviewService userReviewService;

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

    @PostMapping("/{userId}/comment/product/{productId}")
    public ResponseEntity<UserReviewResponse> createNewReview(@PathVariable("productId") Long productId,
                                                              @PathVariable("userId") Long userId,
                                                              @RequestBody UserReviewRequest request) {

        request.setUserId(userId);
        request.setProductId(productId);

        UserReview userReview = userReviewMapper.userReviewRequestToUserReview(request);
        UserReview createdUserReview = userReviewService.createNewUserReview(userReview);

        return new ResponseEntity<>(
                userReviewMapper.toResponse(createdUserReview),
                HttpStatus.CREATED
        );
    }
}
