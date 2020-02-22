package com.example.demo.repository;

import com.example.demo.domain.DebitAccount;
import org.springframework.data.repository.CrudRepository;

public interface DebitAccountRepository extends CrudRepository<DebitAccount, Integer> {

    DebitAccount findByAccountNumber(String accountNumber);
}
