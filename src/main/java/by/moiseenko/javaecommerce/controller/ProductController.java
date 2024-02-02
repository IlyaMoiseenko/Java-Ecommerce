package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(value = "page", required = true, defaultValue = "0") int page,
                                                @RequestParam(value = "size", required = true, defaultValue = "5") int size) {
        return new ResponseEntity<>(
                productService.getAll(page, size),
                HttpStatus.OK
        );
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<Page<Product>> getAllByNameContaining(@PathVariable("productName") String name,
                                                                @RequestParam(value = "page", required = true, defaultValue = "0") int page,
                                                                @RequestParam(value = "size", required = true, defaultValue = "5") int size) {
        return new ResponseEntity<>(
                productService.getAllByName(name, page, size),
                HttpStatus.OK
        );
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<Page<Product>> getAllCategoryName(@PathVariable("categoryName") String categoryName,
                                                            @RequestParam(value = "page", required = true, defaultValue = "0") int page,
                                                            @RequestParam(value = "size", required = true, defaultValue = "3") int size) {
        return new ResponseEntity<>(
                productService.getAllByCategoryName(categoryName, page, size),
                HttpStatus.OK
        );
    }
}