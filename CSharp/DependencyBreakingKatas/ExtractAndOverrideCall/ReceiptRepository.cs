using System;
using MySql.Data.MySqlClient;

namespace Org.Codecop.Dependencies.ExtractAndOverrideCall
{
    public class ReceiptRepository
    {
        private static readonly string databaseName = "myshop";
        private static readonly string user = "store";
        private static readonly string pass = "123456";

        public static void Store(Receipt receipt)
        {
            using (var connection = new MySqlConnection
            {
                ConnectionString = $"Database={databaseName};Data Source=localhost;User Id={user};Password={pass}"
            })
            {
                connection.Open();
                var command = new MySqlCommand("insert into RECEIPT (AMOUNT, TAX, TOTAL)"
                        + "values(@amount, @tax, @total);", connection);
                command.Parameters.AddWithValue("@amount", receipt.Amount.AsDecimal());
                command.Parameters.AddWithValue("@tax", receipt.Tax.AsDecimal());
                command.Parameters.AddWithValue("@total", receipt.Total.AsDecimal());
                command.Prepare();
                command.ExecuteNonQuery();
            }
        }
    }
}
