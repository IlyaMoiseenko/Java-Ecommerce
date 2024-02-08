package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 8.02.24
*/

import by.moiseenko.javaecommerce.domain.UserReview;
import by.moiseenko.javaecommerce.domain.dto.request.UserReviewRequest;
import by.moiseenko.javaecommerce.domain.dto.response.UserReviewResponse;
import by.moiseenko.javaecommerce.service.ProductService;
import by.moiseenko.javaecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserReviewMapper {

    private final UserService userService;
    private final ProductService productService;

    public UserReview userReviewRequestToUserReview(UserReviewRequest request) {
        return UserReview
                .builder()
                .comment(request.getComment())
                .user(userService.getById(request.getUserId()))
                .product(productService.getById(request.getProductId()))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserReviewResponse toResponse(UserReview userReview) {
        return UserReviewResponse
                .builder()
                .userId(userReview.getUser().getId())
                .productId(userReview.getProduct().getId())
                .comment(userReview.getComment())
                .createdAt(userReview.getCreatedAt())
                .build();
    }
}
