package by.moiseenko.javaecommerce.repository;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import by.moiseenko.javaecommerce.domain.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    Page<Promotion> findAllByStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable page);
    Page<Promotion> findAllByEndDate(LocalDate endDate, Pageable page);
}
