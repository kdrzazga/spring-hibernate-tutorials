package org.kd.hbtemplate;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

// H2 In-Memory Database Example shows about storing the database contents into memory.

public class DbInitializer {

    static final String DB_SCRIPT_PATH = System.getProperty("user.dir") + "/src/main/resources/data.sql";
    static final String DB_DRIVER = "org.h2.Driver";
    static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    static final String DB_USER = "";
    static final String DB_PASSWORD = "";

    public void init() throws SQLException {

        try (var connection = getDBConnection()) {
            List<String> lines = Files
                    .lines(Path.of(DB_SCRIPT_PATH), Charset.forName("UTF-8"))
                    .filter(line -> line.length() > 0)
                    .filter(line -> !line.trim().startsWith("--"))
                    .collect(Collectors.toList());

            var extractedCmds = Arrays.asList(
                    String.join(" ", lines)
                            .replace("\n", "")
                            //.replace(";", ";EndOfCommand!")
                            .split(";"));

            var sqlCommands = new Vector<String>(extractedCmds.size());

            extractedCmds.forEach(cmd -> sqlCommands.add(cmd.trim() + ";"));

            connection.setAutoCommit(false);
            final var stmt = connection.createStatement();
            for (String sqlCommand : sqlCommands) {
                stmt.execute(sqlCommand);
            }

            stmt.close();
            connection.commit();
        } catch (Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());

        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}