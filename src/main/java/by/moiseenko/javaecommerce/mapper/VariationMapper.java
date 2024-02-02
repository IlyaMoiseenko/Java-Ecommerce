package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.dto.request.VariationToCreateRequest;
import by.moiseenko.javaecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VariationMapper {

    private final CategoryService categoryService;

    public Variation variationToCreateRequestToVariation(VariationToCreateRequest request) {
        return Variation
                .builder()
                .name(request.getName())
                .category(categoryService.getByName(request.getCategoryName()))
                .build();
    }
}
