DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `shopping_cart`;
DROP TABLE IF EXISTS `adress_customer`;
DROP TABLE IF EXISTS `payment_customer`;
DROP TABLE IF EXISTS `payment_method`;
DROP TABLE IF EXISTS `product_category`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `adress`;
DROP TABLE IF EXISTS `category`;


CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL
) ;

CREATE TABLE `product`(
    `product_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(200) NOT NULL,
    `description` varchar(100) NOT NULL,
    `price` decimal(10,2) NOT NULL,
    `stock` int(11) NOT NULL,
    `supplier` varchar(100) NOT NULL	
) ;

CREATE TABLE `shopping_cart`(
    `shopping_cart_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `customer_id` int(11) NOT NULL,
    `product_id` int(11) NOT NULL,
    `quantity` int(11) NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`),
    FOREIGN KEY (`product_id`) REFERENCES `product`(`product_id`)
) ;  

CREATE TABLE `payment_method`(
    `method_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `method_name` varchar(100) NOT NULL,
    `account_number` varchar(100) ,
    `card_number` varchar(100) ,
    `expiration_date` varchar(100) ,
    `security_code` varchar(100)     
)  ;

CREATE TABLE `adress`(
    `adress_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `street` varchar(100) NOT NULL,
    `city` varchar(100) NOT NULL,
    `province` varchar(100) NOT NULL,
    `zip_code` varchar(100) NOT NULL
) ;

CREATE TABLE `adress_customer`(
    `adress_id` int(11) NOT NULL,
    `customer_id` int(11) NOT NULL,
    FOREIGN KEY (`adress_id`) REFERENCES `adress`(`adress_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`)
    PRIMARY KEY(adress_id, customer_id)
) ;

CREATE TABLE `payment_customer`(
    `method_id` int(11) NOT NULL,
    `customer_id` int(11) NOT NULL,
    PRIMARY KEY(method_id, customer_id),
    FOREIGN KEY (`method_id`) REFERENCES `payment_method`(`method_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`)
) ;

CREATE TABLE `category`(
    `category_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `description` varchar(100) NOT NULL
) ;

CREATE TABLE `product_category`(
    `product_id` int(11) NOT NULL,
    `category_id` int(11) NOT NULL,
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY (`product_id`) REFERENCES `product`(`product_id`),
    FOREIGN KEY (`category_id`) REFERENCES `category`(`category_id`)
;)

CREATE TABLE `order`(
    `order_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `customer_id` int(11) NOT NULL,
    `product_id` int(11) NOT NULL,
    `quantity` int(11) NOT NULL,
    `order_date` datetime NOT NULL,
    `adress_id` int(11) NOT NULL,
    `method_id` int(11) NOT NULL,
    FOREIGN KEY (`product_id`) REFERENCES `product`(`product_id`),
    FOREIGN KEY (`adress_id`) REFERENCES `adress`(`adress_id`),
    FOREIGN KEY (`method_id`) REFERENCES `payment_method`(`method_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`)
) ;


INSERT INTO `customer` (`first_name`, `last_name`, `email`, `username`, `password`, `phone`) VALUES
('John', 'Doe', 'example@gmail.com', 'johndoe', '123456', '1234567890'),
('Jane', 'Doe', 'example@hotmail.com', 'janedoe', '123456', '1234567890'),
('John', 'Smith', 'example@outlook.com', 'johnsmith', '123456', '1234567890'),
('Jane', 'Smith', 'janesmith@gmail.com', 'janesmith', '123456', '1234567890'),
('John', 'Johnson', 'johnjohnson@outlook.com', 'johnjohnson', '123456', '1234567890'),
('Jane', 'Johnson', 'janejohnson@gmail.com', 'janejohnson', '123456', '1234567890'),
('John', 'Brown', 'johnbrown@gmail.com', 'johnbrown', '123456', '1234567890'),
('Jane', 'Brown', 'janebrown@gmail.com', 'janebrown', '123456', '1234567890'),
('John', 'Williams', 'johnwilliams@hotmail.com', 'johnwilliams', '123456', '1234567890'),
('Jane', 'Williams', 'janewilliams@outlook.com', 'janewilliams', '123456', '1234567890');

INSERT INTO `product` (`name`, `description`, `price`, `stock`, `supplier`) VALUES
('Laliga football', 'Official laliga ball', 120.00, 100, 'Supplier 1'),
('Wilson basketball', 'Official Wilson NBA game ball', 115.00, 200, 'Supplier 2'),
('Garden Goal', 'Small goal to play football outdoors', 30.00, 300, 'Supplier 3'),
('Nike sleeveless Shirt', 'Basic white sleeveless nike shirt', 40.00, 400, 'Supplier 4'),
('Spalding indoor ball', 'Spalding indoor basketball', 50.00, 500, 'Supplier 2'),
('Tennis Racket', 'Wilson Tennis Racket', 60.00, 600, 'Supplier 4'),
('Sports Socks', 'White adidas sports socks', 5.00, 700, 'Supplier 1'),
('FC Barlona Home Kit', 'Official nike Fc Barrcelona 2024/25 Home kit', 80.00, 800, 'Supplier 3'),
('LA Lakers 2024/25 city edition', 'Official 2024/25 LA Lakers Nike city edition jersey', 170.00, 900, 'Supplier 3'),
('Jordan 1 white/red', 'Nike Air Jordan 1 shoes red/white', 100.00, 1000, 'Supplier 1');	

INSERT INTO `category` (`name`, `description`) VALUES
('Football', 'All football related products'),
('Basketball', 'All basketball related products'),
('Tennis', 'All tennis related products'),
('Clothing', 'All clothing related products'),
('Footwear', 'All footwear related products'),
('Outdoor', 'All outdoor related products');


INSERT INTO `product_category` (`product_id`, `category_id`) VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 4),
(5, 2),
(6, 3),
(7, 4),
(8, 1),
(9, 2),
(10, 5),
(10, 2),
(8, 4),
(9, 4),
(3, 6);

INSERT INTO `adress` (`street`, `city`, `province`, `zip_code`) VALUES
('1234 Main St', 'Mahon', 'Islas Baleares', '07701'),
('5678 1st St', 'Barcelona', 'Cataluña', '08011'),
('9101 2nd St', 'Madrid', 'Comunidad de Madrid', '28001'),
('1123 3rd St', 'Sevilla', 'Andalucia', '41001'),
('4567 4th St', 'Granada', 'Andalucia', '18001'),
('8910 5th St', 'Zaragoza', 'Aragon', '50001'),
('2345 6th St', 'Valencia', 'Comunidad Valenciana', '46001'),
('6789 7th St', 'Barcelona', 'Cataluña', '08035'),
('1011 8th St', 'Mahon', 'Islas Baleares', '07702'),
('1213 9th St', 'Madrid', 'Comunidad de Madrid', '28003');	

INSERT INTO `adress_customer` (`adress_id`, `customer_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(7, 7),
(8, 8),
(9, 9),
(10, 10)
(1, 9),
(3, 10),
(5, 1),
(7, 2),
(9, 3),
(2, 4),
(4, 5),
(6, 6),
(8, 7),
(10, 8);
;

INSERT INTO `payment_method` (`method_name`,`account_number`,`card_number`, `expiration_date`, `security_code`) VALUES
('Visa Debit Card', null, '123456789012', '12/25', '123'),
('Mastercard Credit Card', null, '987654321098', '12/25', '321'),
('Bank transfer', '234567890', null, null, null),
('Paypal', '345678901', null, null, null),
('Visa Credit Card', null, '15784522', '12/25', '123'),
('Mastercard Debit Card', null, '987654321098', '12/25', '321'),
('Bank transfer', '234567890', null, null, null),
('Mastercard Credit Card', null, '987654321907', '12/25', '321'),
('Bank transfer', '212367890', null, null, null)
('Visa Debit Card', null, '134567901234', '12/25', '123'),

INSERT INTO `payment_customer` (`method_id`, `customer_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 9),
(3, 10),
(5, 1),
(7, 2),
(9, 3),
(2, 4),
(4, 5),
(6, 6),
(8, 7),
(10, 8);

INSERT INTO `shopping_cart` (`customer_id`, `product_id`, `quantity`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(1, 9, 1),
(3, 10, 2),
(5, 1, 3),
(7, 2, 4),
(9, 3, 5),
(2, 4, 6),
(4, 5, 7),
(6, 6, 8),
(8, 7, 9),
(10, 8, 10);	

INSERT INTO `order` (`customer_id`, `product_id`, `quantity`, `order_date`, `adress_id`, `method_id`) VALUES
(1, 1, 1, '2024-01-01 00:00:00', 1, 1),
(2, 2, 2, '2024-01-02 00:00:00', 2, 2),
(3, 3, 3, '2024-01-03 00:00:00', 3, 3),
(4, 4, 4, '2024-01-04 00:00:00', 4, 4),
(5, 5, 5, '2024-01-05 00:00:00', 5, 5),
(6, 6, 6, '2024-01-06 00:00:00', 6, 6),
(7, 7, 7, '2024-01-07 00:00:00', 7, 7),
(8, 8, 8, '2024-01-08 00:00:00', 8, 8),
(9, 9, 9, '2024-01-09 00:00:00', 9, 9),
(10, 10, 10, '2024-01-10 00:00:00', 10, 10),
(1, 9, 1, '2024-01-01 00:00:00', 1, 1),
(3, 10, 2, '2024-01-12 00:00:00', 3, 3),
(5, 1, 3, '2024-01-13 00:00:00', 5, 5),
(7, 2, 4, '2024-01-14 00:00:00', 7, 7),
(9, 3, 5, '2024-01-09 00:00:00', 9, 9),
(2, 4, 6, '2024-01-16 00:00:00', 2, 2),
(4, 5, 7, '2024-01-17 00:00:00', 4, 4),
(6, 6, 8, '2024-01-06 00:00:00', 6, 6),
(8, 7, 9, '2024-01-08 00:00:00', 8, 8),
(10, 8, 10, '2024-01-10 00:00:00', 10, 10);





