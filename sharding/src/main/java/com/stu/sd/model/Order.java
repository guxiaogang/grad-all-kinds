package com.stu.sd.model;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column(name="user_id")
    private Long userId;
    @NotFound(action= NotFoundAction.IGNORE)
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems=new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setUserId(this.getUserId());
        orderItem.setOrder(this);
    }

}
