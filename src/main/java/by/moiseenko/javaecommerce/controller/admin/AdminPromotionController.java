package by.moiseenko.javaecommerce.controller.admin;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import by.moiseenko.javaecommerce.domain.Promotion;
import by.moiseenko.javaecommerce.domain.dto.request.PromotionToCreateRequest;
import by.moiseenko.javaecommerce.mapper.PromotionMapper;
import by.moiseenko.javaecommerce.service.PromotionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/admin/promotion")
@RequiredArgsConstructor
public class AdminPromotionController {

    private final PromotionService promotionService;
    private final PromotionMapper promotionMapper;

    @GetMapping
    public ResponseEntity<Page<Promotion>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "3") int size) {
        return new ResponseEntity<>(
                promotionService.getAll(page, size),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                promotionService.getById(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/date")
    public ResponseEntity<Page<Promotion>> getAllByDate(@RequestParam(value = "start_date") LocalDate startDate,
                                                        @RequestParam("end_date") LocalDate endDate,
                                                        @RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "3") int size) {
        return new ResponseEntity<>(
                promotionService.getAllByDate(startDate, endDate, page, size),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/date/e")
    public ResponseEntity<Page<Promotion>> getAllByEndDate(@RequestParam("end_date") LocalDate endDate,
                                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "3") int size) {
        return new ResponseEntity<>(
                promotionService.getAllByEndDate(endDate, page, size),
                HttpStatus.FOUND
        );
    }

    @PostMapping
    public ResponseEntity<Promotion> createNewPromotion(@RequestBody @Valid PromotionToCreateRequest request) {
        Promotion promotion = promotionMapper.promotionToCreateRequestToPromotion(request);

        return new ResponseEntity<>(
                promotionService.create(promotion),
                HttpStatus.CREATED
        );
    }
}
