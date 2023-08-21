DROP database IF EXISTS `myShop`;
CREATE database `myShop`;
USE `myShop`;

CREATE TABLE IF NOT EXISTS myShop.RECEIPT (
    RECEIPT_ID INT AUTO_INCREMENT,
    AMOUNT DECIMAL NOT NULL,
    TAX DECIMAL NOT NULL,
    TOTAL DECIMAL NOT NULL,
    PRIMARY KEY (RECEIPT_ID)
);

CREATE USER IF NOT EXISTS `store`@`localhost` IDENTIFIED BY '123456';
GRANT INSERT, UPDATE ON myShop.RECEIPT TO `store`@`localhost`;
FLUSH PRIVILEGES;