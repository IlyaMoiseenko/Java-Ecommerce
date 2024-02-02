package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.VariationOption;
import by.moiseenko.javaecommerce.domain.dto.request.ProductRequest;
import by.moiseenko.javaecommerce.domain.dto.request.VariationOptionRequest;
import by.moiseenko.javaecommerce.domain.dto.request.VariationRequest;
import by.moiseenko.javaecommerce.service.CategoryService;
import by.moiseenko.javaecommerce.service.VariationOptionService;
import by.moiseenko.javaecommerce.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class ProductMapper {

    private final VariationService variationService;
    private final VariationOptionService variationOptionService;
    private final CategoryService categoryService;

    public Product productRequestToProduct(ProductRequest request) {
        Product product = Product
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .inStock(request.getInStock())
                .category(categoryService.getByName(request.getProductCategoryName()))
                .variationOptions(new ArrayList<>())
                .build();

        for (VariationRequest variationRequest : request.getVariations()) {
            Variation variation = variationService.getByNameAndCategory(variationRequest.getName(), product.getCategory());

            for (VariationOptionRequest variationOptionRequest : variationRequest.getOptions()) {
                product.getVariationOptions().add(
                        variationOptionService.getByValueAndVariation(variationOptionRequest.getValue(), variation)
                );
            }
        }

        return product;
    }
}
