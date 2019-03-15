package com.stu.sd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_item")
public class OrderItem {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "pay_date")
    private Date payDate;
    @Column(name = "total_price")
    private Float totalPrice;
    @Column(name = "discount")
    private int payDiscount;
    @Column(name = "pay_price")
    private Float payPrice;

    @ManyToOne
    @ElementCollection(targetClass = Order.class)
    private Order order;
}
