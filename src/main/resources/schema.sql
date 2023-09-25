CREATE TABLE IF NOT EXISTS user
(
    ID char(32) NOT NULL,
    code char(8),
    name varchar(80),
    status smallint NOT NULL DEFAULT 1,
    remark varchar(200),
    deleted smallint NOT NULL DEFAULT 0,
    creator char(32),
    create_time bigint,
    PRIMARY KEY (ID)
);

CREATE INDEX uix_user_01 on user(code);

CREATE TABLE IF NOT EXISTS product
(
    ID char(32) NOT NULL,
    code char(8),
    name varchar(80),
    price bigint,
    unit varchar(10),
    remark varchar(200),
    deleted smallint NOT NULL DEFAULT 0,
    creator char(32),
    create_time bigint,
    PRIMARY KEY (ID)
);

CREATE INDEX uix_product_01 on product(code);

CREATE TABLE IF NOT EXISTS orders
(
    ID char(32),
    biz_date int(4),
    order_no char(13),
    status smallint NOT NULL DEFAULT 1,
    remark varchar(200),
    creator char(32),
    create_time bigint,
    PRIMARY KEY (ID),
    FOREIGN KEY (creator) REFERENCES user(ID)
);

CREATE INDEX ix_order_01 on order(biz_date);
CREATE INDEX uix_order_02 on order(order_no);

CREATE TABLE IF NOT EXISTS order_detail
(
    ID char(32),
    order_no char(13),
    seq int(4),
    item_id char(32),
    price bigint(4),
    quantity bigint(4),
    unit varchar (10),
    remark varchar(200),
    PRIMARY KEY (ID),
    FOREIGN KEY (item_id) REFERENCES product(ID)
);

CREATE INDEX ix_order_detail_01 on order_detail(order_no);
CREATE INDEX ix_order_detail_02 on order_detail(item_id);

CREATE TABLE IF NOT EXISTS sys_seq
(
    ID char(32),
    seq_key varchar(20),
    `value` smallint,
    PRIMARY KEY (ID)
);

CREATE INDEX uix_seq_01 on sys_req(key);