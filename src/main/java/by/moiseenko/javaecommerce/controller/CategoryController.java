package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAll() {
        return new ResponseEntity<>(
                categoryService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/name/{categoryName}")
    public ResponseEntity<ProductCategory> getByName(@PathVariable("categoryName") String name) {
        return new ResponseEntity<>(
                categoryService.getByName(name),
                HttpStatus.OK
        );
    }
}
