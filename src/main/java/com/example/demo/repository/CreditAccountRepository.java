package com.example.demo.repository;

import com.example.demo.domain.CreditAccount;
import org.springframework.data.repository.CrudRepository;

public interface CreditAccountRepository extends CrudRepository<CreditAccount, Integer> {

        CreditAccount findByAccountNumber(String accountNumber);


}
