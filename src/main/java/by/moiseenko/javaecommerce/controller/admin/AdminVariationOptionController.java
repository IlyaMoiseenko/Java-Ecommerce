package by.moiseenko.javaecommerce.controller.admin;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.VariationOption;
import by.moiseenko.javaecommerce.domain.dto.request.VariationOptionToCreateRequest;
import by.moiseenko.javaecommerce.mapper.VariationOptionMapper;
import by.moiseenko.javaecommerce.service.VariationOptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/variation-option")
@RequiredArgsConstructor
public class AdminVariationOptionController {

    private final VariationOptionMapper variationOptionMapper;
    private final VariationOptionService variationOptionService;

    @PostMapping
    public ResponseEntity<VariationOption> createNewVariationOption(@RequestBody @Valid VariationOptionToCreateRequest request) {
        VariationOption variationOption = variationOptionMapper.variationOptionToCreateToVariationOption(request);

        return new ResponseEntity<>(
                variationOptionService.createNewVariationOption(variationOption),
                HttpStatus.OK
        );
    }
}
