package com.stu.ns.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@TypeAlias("account")
public class Account {
    @Id
    private String id;
    private Float total;
    private String accountNumber;
}
