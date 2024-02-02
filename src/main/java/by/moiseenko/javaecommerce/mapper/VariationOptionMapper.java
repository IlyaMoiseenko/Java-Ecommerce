package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.VariationOption;
import by.moiseenko.javaecommerce.domain.dto.request.VariationOptionToCreateRequest;
import by.moiseenko.javaecommerce.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VariationOptionMapper {

    private final VariationService variationService;

    public VariationOption variationOptionToCreateToVariationOption(VariationOptionToCreateRequest request) {
        return VariationOption
                .builder()
                .value(request.getValue())
                .variation(variationService.getByName(request.getVariationName()))
                .build();
    }
}
