INSERT INTO `customers` (`id`, `first_name`, `surname`) VALUES (1, 'jordan', 'harrison');
INSERT INTO `items` (`id`, `name`, `value`, `quantity`, `type`, `brand`, `shaft`) VALUES (1, 'Anser', 250.00, 1, 'Putter', 'Taylormade', 'Regular');
INSERT INTO `orders` (id, customer_id) VALUES (1, 1);
INSERT INTO `orders_items` (orderItems_id, order_id, items_id) VALUES (1, 1, 1);