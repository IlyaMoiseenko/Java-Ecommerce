package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserToUpdateRequest {

    @NotNull(message = "This field should not be null")
    @Email(message = "Incorrect email address")
    private String email;

    @NotNull(message = "This field should not be null")
    private String phoneNumber;

    @NotNull(message = "This field should not be null")
    private String password;
}
