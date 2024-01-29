package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAllByCategoryName(String name, Pageable pageable);
}
