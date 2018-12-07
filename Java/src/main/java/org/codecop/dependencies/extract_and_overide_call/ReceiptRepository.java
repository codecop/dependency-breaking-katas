package org.codecop.dependencies.extract_and_overide_call;

public class ReceiptRepository {

    public static void store(Receipt receipt) {
        // access database and do evil side effects ;-)
        System.exit(1);
        // TODO implement basic JDBC logic
    }

}
