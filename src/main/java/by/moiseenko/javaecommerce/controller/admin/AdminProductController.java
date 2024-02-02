package by.moiseenko.javaecommerce.controller.admin;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.dto.request.ProductRequest;
import by.moiseenko.javaecommerce.mapper.ProductMapper;
import by.moiseenko.javaecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/product")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@Valid @RequestBody ProductRequest request) {
        Product product = productMapper.productRequestToProduct(request);

        return new ResponseEntity<>(
                productService.createNewProduct(product),
                HttpStatus.OK
        );
    }
}
