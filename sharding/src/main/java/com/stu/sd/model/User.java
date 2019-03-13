package com.stu.sd.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
}
