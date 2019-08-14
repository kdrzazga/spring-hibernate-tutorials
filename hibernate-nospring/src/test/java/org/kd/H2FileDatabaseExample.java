package org.kd;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;

public class H2FileDatabaseExample {

    @Test
    public void testH2InitializationWithJdbc() {

        try {
            Connection dbConnection = new H2DbInitializer().createDatabase();
            readDb(dbConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void readDb(Connection dbConnection) throws SQLException {

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
