package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 8.02.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.UserReview;
import by.moiseenko.javaecommerce.domain.dto.response.UserReviewResponse;
import by.moiseenko.javaecommerce.mapper.UserReviewMapper;
import by.moiseenko.javaecommerce.service.ProductService;
import by.moiseenko.javaecommerce.service.UserReviewService;
import by.moiseenko.javaecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class UserReviewController {

    private final UserReviewService userReviewService;
    private final UserService userService;
    private final ProductService productService;

    private final UserReviewMapper userReviewMapper;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserReviewResponse>> getAllByUser(@PathVariable("userId") Long id) {
        User user = userService.getById(id);
        List<UserReview> allByUser = userReviewService.getAllByUser(user);

        return new ResponseEntity<>(
                allByUser.stream().map(userReviewMapper::toResponse).toList(),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<UserReviewResponse>> getAllByProduct(@PathVariable("productId") Long id) {
        Product product = productService.getById(id);
        List<UserReview> allByProduct = userReviewService.getAllByProduct(product);

        return new ResponseEntity<>(
                allByProduct.stream().map(userReviewMapper::toResponse).toList(),
                HttpStatus.FOUND
        );
    }
}
