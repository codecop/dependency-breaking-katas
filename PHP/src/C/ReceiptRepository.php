<?php

namespace Org\Codecop\Dependencies\C;

use PDO;

class ReceiptRepository {
    public const URL = "mysql:host=localhost;port=3306;dbname=myShop";
    public const USER = "store";
    public const PASS = "123456";

    public static function store(Receipt $receipt): void {
        $pdo = new PDO(self::URL, self::USER, self::PASS);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $sqlInsert = "insert into RECEIPT (AMOUNT, TAX, TOTAL) values (?, ?, ?)";

        $statement = $pdo->prepare($sqlInsert);
        $statement->bindValue(1, $receipt->getAmount()->asBigDecimal());
        $statement->bindValue(2, $receipt->getTax()->asBigDecimal());
        $statement->bindValue(3, $receipt->getTotal()->asBigDecimal());
        $statement->execute();
    }
}
