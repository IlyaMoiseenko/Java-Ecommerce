package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 6.02.24
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionToCreateRequest {

    @NotNull(message = "This field should not be null")
    private String name;

    @NotNull(message = "This field should not be null")
    private String description;

    @NotNull(message = "This field should not be null")
    private int discountRate;

    @NotNull(message = "This field should not be null")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @NotNull(message = "This field should not be null")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;
}
