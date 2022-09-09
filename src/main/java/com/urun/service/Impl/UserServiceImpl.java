package com.urun.service.Impl;


import com.urun.dto.UserDto;
import com.urun.entity.User;
import com.urun.exceptions.SameEmailException;
import com.urun.repository.UserRepository;
import com.urun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        boolean isExist = userRepository.existsByEmail(user.getEmail());
        if (isExist) {
            throw new SameEmailException("User already signed up with same email: " + user.getEmail());
        }
        return userRepository.save(user);
    }

}
