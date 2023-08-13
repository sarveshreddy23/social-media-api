
CREATE TABLE `user` (
  `id` int NOT NULL,
  `birth_date` date NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `post` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `social-media-app`.`user` (`id`,`birth_date`,`name`) VALUES (101, '2006-08-09', 'Adam');
INSERT INTO `social-media-app`.`user` (`id`,`birth_date`,`name`) VALUES (102, '2000-08-09', 'Eve');
INSERT INTO `social-media-app`.`user` (`id`,`birth_date`,`name`) VALUES (103, '1990-08-09', 'Jack');

INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1001, 'learn aws', 101);
INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1002, 'learn devOps', 101);
INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1003, 'learn Azure', 102);
INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1004, 'learn spring', 102);
INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1005, 'learn Painting', 103);
INSERT INTO `social-media-app`.`post` (`id`, `description`, `user_id`) VALUES (1006, 'learn Alphabets', 103);
