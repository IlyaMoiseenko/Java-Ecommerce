package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.VariationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VariationOptionRepository extends JpaRepository<VariationOption, Long> {

    Optional<VariationOption> findByValue(String value);
    List<VariationOption> findAllByVariation(Variation variation);
    Optional<VariationOption> findByValueAndVariation(String value, Variation variation);
}
