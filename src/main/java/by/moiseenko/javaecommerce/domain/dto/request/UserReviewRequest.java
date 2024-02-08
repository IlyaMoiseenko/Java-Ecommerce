package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 8.02.24
*/

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReviewRequest {

    @NotNull(message = "This field should not be null")
    private String comment;
    private Long userId;
    private Long productId;
}
