package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
