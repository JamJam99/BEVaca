package com.vacatime.services;

import com.vacatime.models.Account;
import com.vacatime.models.AuthRequest;
import com.vacatime.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  //@Autowired
  AccountRepository accountRepository;


  public Account authenticate(AuthRequest authRequest) {

    Account account = new Account(); // accountRepository.findUser(account.getUsername, account.getPassword)

    if (account == null) {
      return null;
    }

    return account;

  }

}
