package org.kd;

import org.h2.tools.DeleteDbFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class H2DbInitializer {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = ""; //doesn't work with sa user like in SpringBoot
    private static final String DB_PASSWORD = "";

    public Connection createDatabase()  {
            Connection dbConnection = createDbConnection();
            fillDatabase(dbConnection);
            return dbConnection;
    }

    private void fillDatabase( Connection dbConnection) {
        try {
            DeleteDbFiles.execute("~", "test", true);
            dbConnection.setAutoCommit(false);
            var stmt = dbConnection.createStatement();

            var pwd = System.getProperty("user.dir");
            var dir = pwd.substring(0, pwd.lastIndexOf("\\"));

            var dbInitScript = new Scanner(new File(dir + "\\hibernate-spring-boot\\target\\classes\\data.sql")).useDelimiter("\\Z").next();
            dbInitScript = dbInitScript.replaceAll("--.*", "");
            dbInitScript = dbInitScript.replaceAll("\r\n", "");

            for (String sqlCommand : dbInitScript.split(";")) {
                stmt.execute(sqlCommand + ";");
            }
            stmt.close();
        }
        catch (SQLException | FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    private Connection createDbConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
