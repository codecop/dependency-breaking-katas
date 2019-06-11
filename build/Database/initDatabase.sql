DROP database IF EXISTS `myShop`;
CREATE database `myShop`;
USE `myShop`;

CREATE TABLE IF NOT EXISTS myShop.receipt (
    receipt_id INT AUTO_INCREMENT,
    amount DECIMAL NOT NULL,
    tax DECIMAL NOT NULL,
    total DECIMAL NOT NULL,
    PRIMARY KEY (receipt_id)
);

CREATE USER IF NOT EXISTS `store`@`localhost` IDENTIFIED BY '123456';
GRANT INSERT, UPDATE ON myShop.receipt TO `store`@`localhost`;
FLUSH PRIVILEGES;
