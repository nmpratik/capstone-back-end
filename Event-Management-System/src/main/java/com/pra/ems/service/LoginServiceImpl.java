package com.pra.ems.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pra.ems.domain.User;
import com.pra.ems.dto.ForgotpassDto;
import com.pra.ems.dto.LoginDto;
import com.pra.ems.dto.LoginResponseDto;
import com.pra.ems.dto.RegisterDto;
import com.pra.ems.exception.DuplicateEmailFoundException;
import com.pra.ems.exception.InvalidRoleException;
import com.pra.ems.exception.UserNotFoundException;
import com.pra.ems.repository.UserRepository;
import com.pra.ems.util.DynamicMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final DynamicMapper dynamicMapper;

    @Override
    public Integer registerUser(RegisterDto dto) {
        if (!"user".equals(dto.getRole()) && !"admin".equals(dto.getRole()))
            throw new InvalidRoleException("Invalid role! Enter admin/user");
        User user = dynamicMapper.convertor(dto, new User());
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailFoundException("Email already used.");
        }
        userRepository.save(user);
        return 1;
    }

    @Override
    public String loginUser(LoginDto dto) {
        Optional<User> op = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

        User user = op.orElseThrow(() -> new UserNotFoundException("Email/Password is not valid"));

        return user.getRole();
    }

    @Override
    public String forgotpass(ForgotpassDto dto) {
        Optional<User> op = userRepository.findByEmail(dto.getEmail());
        op.orElseThrow(() -> new UserNotFoundException("Email Not Found"));

        return "Reset link send to email";
    }

    @Override
    public LoginResponseDto loginUserForResponse(LoginDto dto) {
        Optional<User> op = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

        User user = op.orElseThrow(() -> new UserNotFoundException("Email/Password is not valid"));
        return dynamicMapper.convertor(user, new LoginResponseDto());
    }

}
