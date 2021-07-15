DROP SCHEMA imstest;

CREATE SCHEMA IF NOT EXISTS imstest;

use imstest;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

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

CREATE TABLE IF NOT EXISTS `orders` (
id int AUTO_INCREMENT,  
customer_id int,
PRIMARY KEY (id), 
FOREIGN KEY (customer_id) REFERENCES customers(id));

CREATE TABLE IF NOT EXISTS orders_items (
orderItems_id int AUTO_INCREMENT, 
order_id int, 
items_id int,
PRIMARY KEY (orderItems_id),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (items_id) REFERENCES items(id)
);