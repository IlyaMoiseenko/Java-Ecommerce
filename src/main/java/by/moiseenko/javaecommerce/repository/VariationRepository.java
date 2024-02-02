package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {

    Optional<Variation> findByName(String name);
    Optional<Variation> findByNameAndCategory(String name, ProductCategory category);
    List<Variation> findAllByCategory(ProductCategory productCategory);
}
