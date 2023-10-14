package com.example.wherehouse.service;

import com.example.wherehouse.dto.JwtResponseDto;
import com.example.wherehouse.dto.LoginDto;
import com.example.wherehouse.dto.ResponseDto;
import com.example.wherehouse.dto.UserDto;
import com.example.wherehouse.entity.User;
import com.example.wherehouse.repository.UserRepository;
import com.example.wherehouse.security.JwtUtil;
import com.example.wherehouse.service.mapper.UserMapper;
import com.example.wherehouse.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;


    public ResponseDto<String> createUser(UserDto userDto) {
        if (userDto != null) {
            User user = userMapper.toEntity(userDto);

            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return ResponseDto.<String>builder()
                .success(true)
                .code(0)
                .message("OK")
                .build();
    }

    public ResponseDto<JwtResponseDto> login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email not found!" + loginDto.getUsername()));

        if (!encoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        try {
            String token = jwtUtil.generateToken(String.valueOf(user.getId()));
            return ResponseDto.<JwtResponseDto>builder()
                    .data(new JwtResponseDto(token, DateUtil.oneDay(), null))
                    .message("Success")
                    .code(0)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<JwtResponseDto>builder()
                    .message("Error while generating token: " + e.getMessage()).build();
        }
    }

    public ResponseDto<UserDto> checkToken(String token) {
        Boolean validated =  jwtUtil.validateToken(token);

        return ResponseDto.<UserDto>builder()
                .success(validated)
                .build();
    }
}
