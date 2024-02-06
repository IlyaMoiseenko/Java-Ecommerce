package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import by.moiseenko.javaecommerce.domain.Promotion;
import by.moiseenko.javaecommerce.domain.dto.request.PromotionToCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {

    public Promotion promotionToCreateRequestToPromotion(PromotionToCreateRequest request) {
        return Promotion
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .discountRate(request.getDiscountRate())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
    }
}
