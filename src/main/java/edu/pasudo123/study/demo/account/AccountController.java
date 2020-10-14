package edu.pasudo123.study.demo.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("{id}")
    public Account getAccount(@PathVariable("id") long id) throws InterruptedException {
        log.info("Account Controller come in ...");
        return accountService.getAccountById(id);
    }
}
