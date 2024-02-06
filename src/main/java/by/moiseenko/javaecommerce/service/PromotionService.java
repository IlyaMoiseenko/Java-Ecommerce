package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import by.moiseenko.javaecommerce.domain.Promotion;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public Promotion create(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Transactional(readOnly = true)
    public Page<Promotion> getAll(int page, int size) {
        return promotionRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Promotion getById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Promotion.class, Map.of("id", id.toString())));
    }

    @Transactional(readOnly = true)
    public Page<Promotion> getAllByDate(LocalDate startDate, LocalDate endDate, int page, int size) {
        return promotionRepository.findAllByStartDateBetween(startDate, endDate, PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Page<Promotion> getAllByEndDate(LocalDate endDate, int page, int size) {
        return promotionRepository.findAllByEndDate(endDate, PageRequest.of(page, size));
    }
}
