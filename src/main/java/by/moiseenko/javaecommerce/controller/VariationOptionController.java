package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.VariationOption;
import by.moiseenko.javaecommerce.service.VariationOptionService;
import by.moiseenko.javaecommerce.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/variation-option")
@RequiredArgsConstructor
public class VariationOptionController {

    private final VariationOptionService variationOptionService;
    private final VariationService variationService;

    @GetMapping
    public ResponseEntity<List<VariationOption>> getAll() {
        return new ResponseEntity<>(
                variationOptionService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/value/{valueName}")
    public ResponseEntity<VariationOption> getByValue(@PathVariable("valueName") String valueName) {
        return new ResponseEntity<>(
                variationOptionService.getByValue(valueName),
                HttpStatus.OK
        );
    }

    @GetMapping("/variation/{variationName}")
    public ResponseEntity<List<VariationOption>> getByVariation(@PathVariable("variationName") String variationName) {
        Variation variation = variationService.getByName(variationName);

        return new ResponseEntity<>(
                variationOptionService.getAllByVariation(variation),
                HttpStatus.OK
        );
    }
}
