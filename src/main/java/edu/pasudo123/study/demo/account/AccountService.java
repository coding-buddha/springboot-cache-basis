package edu.pasudo123.study.demo.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    @Cacheable("account")
    public Account getAccountById(final Long id) throws InterruptedException {
        log.info("5초간 sleep ...");
        Thread.sleep(5000L);

        return new Account(id, "PARK", "Seoul");
    }
}
