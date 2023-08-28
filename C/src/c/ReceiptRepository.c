#include <stdio.h>

#include "ReceiptRepository.h"

// public static final String URL = "jdbc:mysql://localhost:3306/myShop";
// public static final String USER = "store";
// public static final String PASS = "123456";

void C_ReceiptRepository_store(const C_Receipt* receipt)
{
    (void)receipt;
    //     String sqlInsert = "insert into RECEIPT "
    //             + "(AMOUNT, TAX, TOTAL)"
    //             + "values(?, ?, ?)";

    //     try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
    //          PreparedStatement statement = connection.prepareStatement(sqlInsert);
    //     ) {
    //         statement.setBigDecimal(1, receipt.getAmount().asBigDecimal());
    //         statement.setBigDecimal(2, receipt.getTax().asBigDecimal());
    //         statement.setBigDecimal(3, receipt.getTotal().asBigDecimal());
    //         statement.executeUpdate();

    //     } catch (SQLException ex) {
    //         throw new SQLRuntimeException("Database error " + receipt, ex);
    //     }
}
