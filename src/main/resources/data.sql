insert into user (ID, code, name, create_time) values
(REPLACE(UUID(), '-', ''), "user01", "ellen", UNIX_TIMESTAMP()),
(REPLACE(UUID(), '-', ''), "user02", "jack", UNIX_TIMESTAMP()),
(REPLACE(UUID(), '-', ''), "user03", "eddy", UNIX_TIMESTAMP());
--
insert into product (id, code, name, price, unit, create_time) values
(REPLACE(UUID(), '-', ''), "product1", "perfume", 50, "Pcs", UNIX_TIMESTAMP()),
(REPLACE(UUID(), '-', ''), "product2", "watch", 200, "Pcs", UNIX_TIMESTAMP()),
(REPLACE(UUID(), '-', ''), "product3", "wallet", 100, "Pcs", UNIX_TIMESTAMP());