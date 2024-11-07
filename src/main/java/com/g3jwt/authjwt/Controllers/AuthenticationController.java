package com.g3jwt.authjwt.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3jwt.authjwt.Dtos.LoginUserDto;
import com.g3jwt.authjwt.Dtos.RegisterUserDto;
import com.g3jwt.authjwt.Entities.User;
import com.g3jwt.authjwt.ResponseToken.LoginReponse;
import com.g3jwt.authjwt.Services.AuthenticationService;
import com.g3jwt.authjwt.Services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
     private final JwtService jwtService;
    private final AuthenticationService authenticationService;
   
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody RegisterUserDto registerUserDto){
        User userreg = authenticationService.signUp(registerUserDto);

        return ResponseEntity.ok(userreg);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginReponse> login(@RequestBody LoginUserDto loginUserDto){
        User userlog = authenticationService.Login(loginUserDto);

        String jwtToken = jwtService.generateToken(userlog);

        LoginReponse loginReponse = new LoginReponse();
        loginReponse.setToken(jwtToken);
        loginReponse.setExpirationTimeIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginReponse);
    }
}
