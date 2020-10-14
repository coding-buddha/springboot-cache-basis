package edu.pasudo123.study.demo.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Account {

    private final Long id;
    private final String name;
    private final String address;
}
