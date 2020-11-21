package com.vacatime.repositories;

import com.vacatime.models.Account;
import com.vacatime.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository <Account, Long> {

}