package org.kd;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

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

        try {
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

        } finally {
            dbConnection.close();
        }
    }
}
