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
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL
) ;

CREATE TABLE `product`(
    `product_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `description` varchar(45) NOT NULL,
    `price` decimal(10,2) NOT NULL,
    `stock` int(11) NOT NULL,
    `supplier` varchar(45) NOT NULL	
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
    `card_number` varchar(45) NOT NULL,
    `expiration_date` varchar(45) NOT NULL,
    `security_code` varchar(45) NOT NULL    
)  ;

CREATE TABLE `adress`(
    `adress_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `street` varchar(45) NOT NULL,
    `city` varchar(45) NOT NULL,
    `state` varchar(45) NOT NULL,
    `zip_code` varchar(45) NOT NULL
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
    `name` varchar(45) NOT NULL,
    `description` varchar(45) NOT NULL
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

