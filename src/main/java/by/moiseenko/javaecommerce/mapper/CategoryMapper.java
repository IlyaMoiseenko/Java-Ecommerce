package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.dto.request.CategoryToCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public ProductCategory categoryToCreateRequestToCategory(CategoryToCreateRequest request) {
        return ProductCategory
                .builder()
                .name(request.getName())
                .build();
    }
}
