show databases ;

create database if not exists FamilyFinanceManagementSystem;
use FamilyFinanceManagementSystem;


-- 创建家庭成员表
CREATE TABLE `income` (
                          `income_id` INT AUTO_INCREMENT PRIMARY KEY,
                          `member_id` INT,
                          `amount` DECIMAL(10, 2) NOT NULL,
                          `category` VARCHAR(64),
                          `income_date` DATE,
                          `family_id` int,
                          FOREIGN KEY (`category`) REFERENCES `category` (`name`),
                          foreign key (family_id) references family(family_id),
                          FOREIGN KEY (`member_id`) REFERENCES `family_member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 创建收入表
CREATE TABLE `expense` (
                           `expense_id` INT AUTO_INCREMENT PRIMARY KEY,
                           `member_id` INT,
                           `category` varchar(64),
                           `amount` DECIMAL(10, 2) NOT NULL,
                           `description` VARCHAR(255),
                           `expense_date` DATE,
                           `family_id` int,
                           foreign key (family_id) references family(family_id),
                           FOREIGN KEY (`category`) REFERENCES `category` (`name`),
                           FOREIGN KEY (`member_id`) REFERENCES `family_member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 创建支出表
CREATE TABLE `family_member` (
                                 `member_id` INT AUTO_INCREMENT PRIMARY KEY,
                                 `name` VARCHAR(64) NOT NULL,
                                 `relation` VARCHAR(64),
                                 `birth_date` DATE,
                                 `family_id` int,
                                 foreign key (family_id) references family(family_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 创建资产管理表
CREATE TABLE `asset` (
                         `asset_id` INT AUTO_INCREMENT PRIMARY KEY,
                         `category` varchar(64),
                         `description` VARCHAR(255),
                         `value` DECIMAL(10, 2),
                         `member_id` INT,
                         `acquisition_date` DATE,
                         `family_id` int,
                         FOREIGN KEY (`category`) REFERENCES `category` (`name`),
                         foreign key (family_id) references family(family_id),
                         FOREIGN KEY (`member_id`) REFERENCES `family_member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 创建收支分类表
CREATE TABLE `category` (
                            `category_id` INT AUTO_INCREMENT PRIMARY KEY,
                            `name` VARCHAR(64) NOT NULL UNIQUE ,
                            `parent_category_id` INT,
                            FOREIGN KEY (`parent_category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
                        `user_id` INT AUTO_INCREMENT PRIMARY KEY,
                        `username` VARCHAR(64) NOT NULL,
                        `password` VARCHAR(255) NOT NULL,
                        `is_admin` BOOLEAN NOT NULL DEFAULT FALSE,
                        `family_member_id` INT,
                        FOREIGN KEY (`family_member_id`) REFERENCES `family_member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `family` (
                          `family_id` INT AUTO_INCREMENT PRIMARY KEY,
                          `num` INT NOT NULL,
                          `family_name` VARCHAR(64) NOT NULL,
                          `activate_code` VARCHAR(255) NOT NULL,
                          `description` TEXT,
                          CONSTRAINT UK_family_name UNIQUE (`family_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



