package com.quiz.controller;

import com.quiz.config.JWTHelper;
import com.quiz.controller.jwtrespandrequest.JWTRequest;
import com.quiz.controller.jwtrespandrequest.JWTResponse;
import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/jwtquiz")
public class JWTQuizController {

    @Autowired
    private QuizService quizService;

    //Following Three autowired are used for JWT Purpose.

    @Autowired
    private UserDetailsService userDetailsService;  //Used for fetch User Details

    //Following AuthenticationManager we fetch from Config(CentralConfig) file, there we create one bean for this.
    //Following used for to Authenticate
    @Autowired
    private AuthenticationManager authenticationManager;

    //Used for to create JWT.
    @Autowired
    private JWTHelper jwtHelper;


    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        String token = this.jwtHelper.generateToken(userDetails);

        System.out.println("Check Token: "+ token);
        JWTResponse jwtResponse = new JWTResponse(token, userDetails.getUsername());

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
