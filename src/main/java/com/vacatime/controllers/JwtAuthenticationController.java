package com.vacatime.controllers;

import com.vacatime.models.Account;
import com.vacatime.models.AuthRequest;
import com.vacatime.models.JwtResponse;
import com.vacatime.services.AuthenticationService;
import com.vacatime.services.JwtUserDetailsService;
import com.vacatime.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


//    //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
////    final UserDetails userDetails = userDetailsService
////        .loadUserByUsername(authenticationRequest.getUsername());
//    Account account = authenticationService.authenticate(authenticationRequest);
//
//    if (account == null) {
//      ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Account());
//    }
//    final String token = jwtTokenUtil.generateToken(account);
//    return ResponseEntity.ok(new JwtResponse(token));
//  }
//
//  @RequestMapping(value = "/hello", method = RequestMethod.GET)
//  public ResponseEntity<?> hello() throws Exception {
//
//    return ResponseEntity.ok("Hello Jamal");
//  }
////  private void authenticate(String username, String password) throws Exception {
////    try {
////      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
////    } catch (DisabledException e) {
////      throw new Exception("USER_DISABLED", e);
////    } catch (BadCredentialsException e) {
////      throw new Exception("INVALID_CREDENTIALS", e);
////    }
////  }
}
