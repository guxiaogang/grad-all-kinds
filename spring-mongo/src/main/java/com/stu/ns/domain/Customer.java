package com.stu.ns.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Document(collection = "Customer")
@TypeAlias("customer")
public class Customer {
    @Id
    String id;
    @Indexed
    String name;
    Date birthday;
    Set<Address> addresses;
    @DBRef
    Set<Account> accounts;

    private Product product;

    public void addAddress(Address address) {
        if (addresses == null) {
            this.addresses = new HashSet<>();
        }
        this.addresses.add(address);
    }

    public void addAccount(Account account) {
        if (account == null) {
            this.accounts = new HashSet<>();
        }
        this.accounts.add(account);
    }
}
