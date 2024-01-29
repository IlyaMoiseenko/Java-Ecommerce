package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.Address;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.javaecommerce.domain.dto.request.UserToUpdateRequest;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.mapper.AddressMapper;
import by.moiseenko.javaecommerce.repository.AddressRepository;
import by.moiseenko.javaecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;
    private final PasswordEncoder passwordEncoder;

    public User addNewAddress(AddressRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(User.class, Map.of("id", userId.toString())));

        Address address = addressMapper.addressRequestToAddress(request);

        Optional<Address> addressByAddressLine = addressRepository.findByAddressLine(address.getAddressLine());
        if (addressByAddressLine.isPresent())
            address = addressByAddressLine.get();

        user.getAddresses().add(address);

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, Map.of("id", id.toString())));
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(Long id, UserToUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, Map.of("id", id.toString())));

        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }
}
