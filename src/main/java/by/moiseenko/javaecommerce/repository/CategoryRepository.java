package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findByName(String name);
}
