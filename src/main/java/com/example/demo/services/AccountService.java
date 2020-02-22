package com.example.demo.services;

import com.example.demo.domain.CreditAccount;
import com.example.demo.domain.DebitAccount;
import com.example.demo.repository.CreditAccountRepository;
import com.example.demo.repository.DebitAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountService {

    @Autowired
    CreditAccountRepository creditAccountRepository;
    @Autowired
    DebitAccountRepository debitAccountRepository;


    public void addToCreditAccount(String accountNumber, BigDecimal amount) {
        CreditAccount creditAccount = creditAccountRepository.findByAccountNumber(accountNumber);
        creditAccount.setBalance(creditAccount.getBalance().add(amount));
        creditAccountRepository.save(creditAccount);

    }

    public void addToDebitAccount(String accountNumber, BigDecimal amount) {
        DebitAccount debitAccount = debitAccountRepository.findByAccountNumber(accountNumber);
        debitAccount.setBalance(debitAccount.getBalance().add(amount));
        debitAccountRepository.save(debitAccount);

    }

    public void subtractFromCreditAccount(String accountNumber, BigDecimal amount) {
        CreditAccount creditAccount = creditAccountRepository.findByAccountNumber(accountNumber);
        creditAccount.setBalance(creditAccount.getBalance().subtract(amount));
        creditAccountRepository.save(creditAccount);

    }

    public void subtractFromDebitAccount(String accountNumber, BigDecimal amount) {
        DebitAccount debitAccount = debitAccountRepository.findByAccountNumber(accountNumber);
        debitAccount.setBalance(debitAccount.getBalance().subtract(amount));
        debitAccountRepository.save(debitAccount);
    }

    public BigDecimal getCreditAccountBalance(String accountNumber) {
        CreditAccount creditAccount = creditAccountRepository.findByAccountNumber(accountNumber);
        return creditAccount.getBalance();
    }

    public BigDecimal getDebitAccountBalance(String accountNumber) {
        DebitAccount debitAccount = debitAccountRepository.findByAccountNumber(accountNumber);
        return debitAccount.getBalance();
    }

}

