package com.stu.sd.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="province")
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @Column(name="name")
    private String name;
}
