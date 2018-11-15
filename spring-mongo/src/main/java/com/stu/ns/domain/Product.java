package com.stu.ns.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Product")
@TypeAlias("product")
public class Product {
    @Id
    String id;
    String prodName;
    String prodDesc;
    Double prodPrice;
    String prodImage;
}
