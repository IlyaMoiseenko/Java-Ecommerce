package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String name);
}
