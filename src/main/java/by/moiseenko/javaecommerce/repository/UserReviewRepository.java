package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 8.02.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {

    List<UserReview> findAllByUser(User user);
    List<UserReview> findAllByProduct(Product product);
}
