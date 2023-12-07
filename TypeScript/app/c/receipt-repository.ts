import {Receipt} from "./receipt";
import {Connection, MysqlError} from "mysql";

let mysql = require('mysql');

const db: Connection = mysql.createConnection({
    host: 'localhost:3306',
    user: 'store',
    password: '12345',
    database: 'store'
});

export class ReceiptRepository {

    static store(receipt: Receipt): Promise<Error | boolean> {
        return new Promise((resolve, reject) => {
            db.connect((err: MysqlError) => {
                if (err) {
                    reject(err);
                } else {

                    db.query(
                        "insert into RECEIPT (AMOUNT, TAX, TOTAL) values(?, ?, ?)",
                        [receipt.amount.value, receipt.tax.value, receipt.total.value],
                        (err, results) => {
                            if (err) {
                                reject(err);
                            }
                            if (!results[0]) {
                                reject(new Error('Data not inserted?'))
                            }
                            resolve(true);
                        });

                    db.end();
                }
            });
        });
    }
}