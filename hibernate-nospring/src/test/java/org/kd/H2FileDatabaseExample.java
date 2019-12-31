package org.kd;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class H2FileDatabaseExample {

    @Test
    public void testH2InitializationWithJdbc() {

        Connection dbConnection = new H2DbInitializer().createDatabase();
        readDb(dbConnection);
    }

    private void readDb(Connection dbConnection) {

        try (dbConnection) {
            var stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from TRD_funds;");

            while (rs.next()) {
                assertNotNull(rs.getLong("id"));
                assertNotNull(rs.getString("name"));
                assertNotNull(rs.getString("shortname"));
            }

            stmt.close();
            dbConnection.commit();
        } catch (Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());

        }
    }
}
