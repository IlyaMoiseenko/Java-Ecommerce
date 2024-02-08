package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 8.02.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.UserReview;
import by.moiseenko.javaecommerce.repository.UserReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserReviewService {

    private final UserReviewRepository userReviewRepository;

    public UserReview createNewUserReview(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @Transactional(readOnly = true)
    public List<UserReview> getAllByUser(User user) {
        return userReviewRepository.findAllByUser(user);
    }

    @Transactional(readOnly = true)
    public List<UserReview> getAllByProduct(Product product) {
        return userReviewRepository.findAllByProduct(product);
    }
}
