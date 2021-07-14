DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
id int AUTO_INCREMENT NOT NULL, 
name varchar(30), 
value double,
quantity int, 
type VARCHAR(30), 
brand VARCHAR(30), 
shaft VARCHAR(20), 
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
id int AUTO_INCREMENT,  
customer_id int,
PRIMARY KEY (id), 
FOREIGN KEY (customer_id) REFERENCES customers(id));
);


DROP TABLE IF EXISTS `orders_items`;

CREATE TABLE orders_items(
orderItems_id int NOT NULL AUTO_INCREMENT, 
order_id int NOT NULL, 
items_id int NOT NULL,
PRIMARY KEY (orderItems_id),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (items_id) REFERENCES items(id)
);