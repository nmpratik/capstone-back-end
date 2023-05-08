package com.pra.ems.service;

import com.pra.ems.dto.ForgotpassDto;
import com.pra.ems.dto.LoginDto;
import com.pra.ems.dto.LoginResponseDto;
import com.pra.ems.dto.RegisterDto;

public interface LoginService {
    Integer registerUser(RegisterDto dto);

    String loginUser(LoginDto dto);

    String forgotpass(ForgotpassDto dto);

    LoginResponseDto loginUserForResponse(LoginDto dto);
}
