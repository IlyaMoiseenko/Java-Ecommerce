package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.Country;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotNull(message = "This field should not be null")
    @Email(message = "Incorrect email address")
    private String email;

    @NotNull(message = "This field should not be null")
    private String phoneNumber;

    @NotNull(message = "This field should not be null")
    private String password;

    @NotNull(message = "This field should not be null")
    private Country country;
}
