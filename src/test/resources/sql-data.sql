INSERT INTO `customers` (`first_name`, `surname`) VALUES ('dummy', 'value');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`item_name`, `price`) VALUES ('dummy',1.00);
INSERT INTO `items` (`item_name`, `price`) VALUES ('pie',2.00);
INSERT INTO `orders` (`id_customers`, `total`) VALUES (1 , 5.70);
INSERT INTO `orders` (`id_customers`, `total`) VALUES (1 , 6.60);  
INSERT INTO `orders_items` (`id_orders`,`id_items`) VALUES (1,1);
