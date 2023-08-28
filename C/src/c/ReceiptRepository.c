#include <mysql/mysql.h>
#include <stdlib.h> /* EXIT_FAILURE */
#include <string.h> /* strlen */

#include "ReceiptRepository.h"

int C_ReceiptRepository_store(const C_Receipt* receipt)
{
    MYSQL* conn;

    conn = mysql_init(NULL);
    if (conn == NULL) {
        return EXIT_FAILURE;
    }

    if (mysql_real_connect(conn, "localhost", "store", "123456", "myShop", 0, NULL, 0) == NULL) {
        mysql_close(conn);
        return EXIT_FAILURE;
    }

    const char* query = "INSERT INTO RECEIPT (AMOUNT, TAX, TOTAL) VALUES (?, ?, ?)";
    MYSQL_STMT* stmt = mysql_stmt_init(conn);
    if (stmt == NULL) {
        mysql_close(conn);
        return EXIT_FAILURE;
    }

    if (mysql_stmt_prepare(stmt, query, strlen(query)) != 0) {
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return EXIT_FAILURE;
    }

    MYSQL_BIND bindParams[3];
    memset(bindParams, 0, sizeof(bindParams));

    double bindDouble0 = C_Money_asDouble(C_Receipt_getAmount(receipt));
    bindParams[0].buffer_type = MYSQL_TYPE_DOUBLE;
    bindParams[0].buffer = &bindDouble0;

    double bindDouble1 = C_Money_asDouble(C_Receipt_getTax(receipt));
    bindParams[1].buffer_type = MYSQL_TYPE_DOUBLE;
    bindParams[1].buffer = &bindDouble1;

    double bindDouble2 = C_Money_asDouble(C_Receipt_getTotal(receipt));
    bindParams[2].buffer_type = MYSQL_TYPE_DOUBLE;
    bindParams[2].buffer = &bindDouble2;

    if (mysql_stmt_bind_param(stmt, bindParams) != 0) {
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return EXIT_FAILURE;
    }

    if (mysql_stmt_execute(stmt) != 0) {
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return EXIT_FAILURE;
    }

    mysql_stmt_close(stmt);
    mysql_close(conn);

    return EXIT_SUCCESS;
}
