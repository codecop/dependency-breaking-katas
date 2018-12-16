package org.codecop.dependencies.extract_and_override_call;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceiptRepository {

    public static final String URL = "jdbc:mysql://localhost:3306/myShop";
    public static final String USER = "store";
    public static final String PASS = "123456";

    public static void store(Receipt receipt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLRuntimeException("Could not load DB driver", ex);
        }

        String sqlInsert = "insert into RECEIPT "
                + "(AMOUNT, TAX, TOTAL)"
                + "values(?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(sqlInsert);
        ) {
            statement.setBigDecimal(1, receipt.getAmount().asBigDecimal());
            statement.setBigDecimal(2, receipt.getTax().asBigDecimal());
            statement.setBigDecimal(3, receipt.getTotal().asBigDecimal());
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new SQLRuntimeException("Database error " + receipt, ex);
        }

    }
}
