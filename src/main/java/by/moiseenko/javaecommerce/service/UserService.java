package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.Address;
import by.moiseenko.javaecommerce.domain.User;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.mapper.AddressMapper;
import by.moiseenko.javaecommerce.repository.AddressRepository;
import by.moiseenko.javaecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

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
}
