
CREATE TABLE `secret_user` (
  `user_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(30) ,
  `last_name` varchar(30) ,
  `code_name` varchar(20) ,
  `country` varchar(30) ,
  `organization` varchar(30) ,
  `salary` int(11) ,
  `knows_kung_fu` tinyint(1) 
) ;



INSERT INTO `secret_user` (`user_id`, `first_name`, `last_name`, `code_name`, `country`, `organization`, `salary`, `knows_kung_fu`) VALUES
(1, 'James', 'Bond', '007', 'United Kingdom', 'MI6', 165000, 1),
(2, 'Jack', 'Ryan', 'Neo 2.0', 'USA', 'CIA', 132000, 1),
(3, 'Mortadelo', 'Garcia', 'Embutido', 'Spain', 'CNI', 132000, 1),
(4, 'Filemon', 'Lopez', 'Filete', 'Spain', 'CNI', 132000, 0),
(5, 'Nick', 'Fury', 'Foxtrot', 'USA', 'CIA', 165000, 1),
(6, 'Tony', 'Stark', 'Iron Man', 'USA', 'CIA', 165000, 1),
(7, 'George', 'Smiley', 'Beggarman', 'United Kingdom', 'MI6', 165000, 1),
(8, 'Jason', 'Bourne', 'Delta One', 'USA', 'CIA', 110000, 1);




