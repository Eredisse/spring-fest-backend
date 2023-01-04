-- liquibase formatted sql

-- changeset liquibase:1

CREATE TABLE IF NOT EXISTS `fest_signers` (
                                              `id` bigint NOT NULL AUTO_INCREMENT,
                                              `name` varchar(255) DEFAULT NULL,
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `fest_stages` (
                                             `id` bigint NOT NULL AUTO_INCREMENT,
                                             `genre` varchar(255) DEFAULT NULL,
                                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fest_performances` (
                                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                                   `singer_id` bigint DEFAULT NULL,
                                                   `stage_id` bigint DEFAULT NULL,
                                                   `end_time` datetime DEFAULT NULL,
                                                   `start_time` datetime DEFAULT NULL,
                                                   PRIMARY KEY (`id`),
                                                   KEY `FKill3pushm1yiu4he3qio1qq9d` (`singer_id`),
                                                   KEY `FKjna1hay7xsgd9pr0dvv820sa8` (`stage_id`),
                                                   CONSTRAINT `FKill3pushm1yiu4he3qio1qq9d` FOREIGN KEY (`singer_id`) REFERENCES `fest_signers` (`id`),
                                                   CONSTRAINT `FKjna1hay7xsgd9pr0dvv820sa8` FOREIGN KEY (`stage_id`) REFERENCES `fest_stages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fest_users` (
                                            `id` bigint NOT NULL AUTO_INCREMENT,
                                            `email` varchar(255) DEFAULT NULL,
                                            `name` varchar(255) DEFAULT NULL,
                                            `password` varchar(255) DEFAULT NULL,
                                            `role` varchar(255) DEFAULT NULL,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fest_tickets` (
                                              `id` bigint NOT NULL AUTO_INCREMENT,
                                              `ticket_type` varchar(255) DEFAULT NULL,
                                              `user_id` bigint DEFAULT NULL,
                                              `price` bigint DEFAULT NULL,
                                              `is_available` bit(1) NOT NULL,
                                              `ticket_code` varchar(255) DEFAULT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE KEY `UK_jpjhqrge7x1h79flq5ftwui2a` (`ticket_code`),
                                              KEY `FKj4xnx6v4swyujbgn9th1l9c9h` (`user_id`),
                                              CONSTRAINT `FKj4xnx6v4swyujbgn9th1l9c9h` FOREIGN KEY (`user_id`) REFERENCES `fest_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
