package org.codecop.dependencies.extract_and_overide_call;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceiptRepository {
    public static final String URL = "jdbc:mysql://localhost:3306/myShop";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static void store(Receipt receipt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException("Could not load DB driver", ex);
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
            System.err.println(ex.getMessage());
            throw new RuntimeException("Database error", ex);
        }

    }

}
