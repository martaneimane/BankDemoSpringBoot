package com.example.demo;

import com.example.demo.domain.CreditAccount;
import com.example.demo.domain.DebitAccount;
import com.example.demo.repository.CreditAccountRepository;
import com.example.demo.repository.DebitAccountRepository;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class BankDemoSpringBootApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CreditAccountRepository creditAccountRepository;
    @Autowired
    DebitAccountRepository debitAccountRepository;
    @Autowired
    AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(BankDemoSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        CreditAccount firstCreditAccount = new CreditAccount();
        firstCreditAccount.setAccountNumber("LV12HABA12345678");
        firstCreditAccount.setBalance(new BigDecimal(1500.00));
        firstCreditAccount.setDetails("Credit Account");
        creditAccountRepository.save(firstCreditAccount);

        DebitAccount firstDebitAccount = new DebitAccount();
        firstDebitAccount.setAccountNumber("LV36HABA12345678");
        firstDebitAccount.setBalance(new BigDecimal(700.00));
        firstDebitAccount.setDetails("Debit Account");
        debitAccountRepository.save(firstDebitAccount);


        System.out.println("Credit Account Balance: " + accountService.getCreditAccountBalance("LV12HABA12345678"));
        accountService.addToCreditAccount("LV12HABA12345678", new BigDecimal(200.00));
        System.out.println("Credit Account Balance: " + accountService.getCreditAccountBalance("LV12HABA12345678"));
        accountService.subtractFromCreditAccount("LV12HABA12345678", new BigDecimal(150.00));
        System.out.println("Credit Account Balance: " + accountService.getCreditAccountBalance("LV12HABA12345678"));


        System.out.println("Debit Account Balance:" + accountService.getDebitAccountBalance("LV36HABA12345678"));
        accountService.addToDebitAccount("LV36HABA12345678", new BigDecimal(52.56));
        System.out.println("Debit Account Balance:" + accountService.getDebitAccountBalance("LV36HABA12345678"));
        accountService.subtractFromDebitAccount("LV36HABA12345678", new BigDecimal(15.89));
        System.out.println("Debit Account Balance:" + accountService.getDebitAccountBalance("LV36HABA12345678"));



    }
}
