CREATE TABLE province
(
  id      bigint(20) NOT NULL,
  name    varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE user
(
  id      bigint(20) NOT NULL,
  name    varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE t_order
(
  id      bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE order_item_0
(
  id       bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  order_id bigint(20) NOT NULL,
  brand_name varchar(100),
  product_name  varchar(100),
  order_date datetime,
  pay_date datetime,
  total_price numeric(10,2),
  discount numeric(4),
  pay_price numeric(10,2),
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE order_item_1
(
  id       bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  order_id bigint(20) NOT NULL,
  brand_name varchar(100),
  product_name  varchar(100),
  order_date datetime,
  pay_date datetime,
  total_price numeric(10,2),
  discount numeric(4),
  pay_price numeric(10,2),
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

/* hint sharding tables */

CREATE TABLE t_order_0
(
  id      bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE t_order_1
(
  id      bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

/* hint sharding tables end*/