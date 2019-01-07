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
            try
            {
                using (var connection = new MySqlConnection
                {
                    ConnectionString = $"Database={databaseName};Data Source=localhost;User Id={user};Password={pass}"
                })
                {
                    connection.Open();
                    var command = new MySqlCommand("insert into RECEIPT (AMOUNT, TAX, TOTAL)"
                            + "values(@amount, @tax, @total);", connection);
                    command.Parameters.AddWithValue("@amount", receipt.Amount.AsBigDecimal());
                    command.Parameters.AddWithValue("@tax", receipt.Tax.AsBigDecimal());
                    command.Parameters.AddWithValue("@total", receipt.Total.AsBigDecimal());
                    command.Prepare();
                    command.ExecuteNonQuery();
                }
            }
            catch (Exception exc)
            {
                throw new SqlRuntimeException("Database error " + receipt, exc);
            }
           
        }
    }
}