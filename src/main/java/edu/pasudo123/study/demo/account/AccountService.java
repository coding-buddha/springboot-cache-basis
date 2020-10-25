package edu.pasudo123.study.demo.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    @Cacheable(value = "account")
    public Account getAccountById(final Long id) throws InterruptedException {
        log.info("5초간 sleep ...");
        Thread.sleep(5000L);

        return new Account(id, "PARK", "Seoul");
    }

    @CachePut("account")
    public Account updateAccountById(final Long id) {
        log.info("update account");

        return new Account(id, "New Park", "new Seoul");
    }

    @CacheEvict(cacheNames = "account", allEntries = true, beforeInvocation = true)
    public String deleteAllAccount() {
        // allEntries 옵션을 주어서 cacheNames 에 대한 전체 캐시를 삭제한다.
        // cacheNames 는 @Cacheable 의 값과 일치하여야 한다.
        return "delete all account";
    }
}
