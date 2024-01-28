package by.moiseenko.javaecommerce.service;

import by.moiseenko.javaecommerce.config.JwtService;
import by.moiseenko.javaecommerce.domain.Country;
import by.moiseenko.javaecommerce.domain.Role;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.UserPrincipal;
import by.moiseenko.javaecommerce.domain.dto.request.AuthenticationRequest;
import by.moiseenko.javaecommerce.domain.dto.request.RegisterRequest;
import by.moiseenko.javaecommerce.domain.dto.response.AuthenticationResponse;
import by.moiseenko.javaecommerce.repository.CountryRepository;
import by.moiseenko.javaecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
    @author Ilya Moiseenko on 28.01.24
*/

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String TOKEN;

    public User register(RegisterRequest request) {
        Optional<Country> countryByName = countryRepository.findByName(request.getCountry().getName());
        countryByName.ifPresent(request::setCountry);

        User userToRegister = User
                .builder()
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .country(request.getCountry())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(userToRegister);

        return userToRegister;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Optional<User> byEmail = userRepository.findByEmail(request.getEmail());
        if (byEmail.isPresent()) {
            User user = byEmail.get();

            UserPrincipal userPrincipal = UserPrincipal
                    .builder()
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .build();

            TOKEN = jwtService.generateToken(userPrincipal);
        }

        return AuthenticationResponse
                .builder()
                .token(TOKEN)
                .build();
    }
}
