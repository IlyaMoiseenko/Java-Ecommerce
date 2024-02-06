package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.repository.CategoryRepository;
import by.moiseenko.javaecommerce.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduledService {

    private final CategoryRepository categoryRepository;
    private final PromotionRepository promotionRepository;

    @Scheduled(cron = "0 0 * * * *", zone = "Europe/Moscow")
    public void scheduledCategoryPromotion() {
        List<ProductCategory> allCategories = categoryRepository.findAll();
        LocalDate currentDate = LocalDate.now();

        for (ProductCategory category : allCategories) {
            LocalDate endDatePromotion = category.getPromotion().getEndDate();

            if (currentDate.isBefore(endDatePromotion))
                promotionRepository.delete(category.getPromotion());
        }
    }
}
