package by.moiseenko.javaecommerce.controller.admin;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.dto.request.CategoryToCreateRequest;
import by.moiseenko.javaecommerce.mapper.CategoryMapper;
import by.moiseenko.javaecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/category")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ResponseEntity<ProductCategory> createNewCategory(@RequestBody CategoryToCreateRequest request) {
        ProductCategory category = categoryMapper.categoryToCreateRequestToCategory(request);

        return new ResponseEntity<>(
                categoryService.createNewCategory(category),
                HttpStatus.OK
        );
    }
}
