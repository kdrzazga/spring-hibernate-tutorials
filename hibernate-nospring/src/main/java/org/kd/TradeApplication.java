package org.kd;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TradeApplication {

    public static void main(String[] args) {
        System.setProperty("H2_HOME", "d:/tmp/h2db/");
        String[] params = new String[]{"-tcpPort", "8081", "-tcp", "-tcpAllowOthers", "-baseDir", "c:/h2"};
        var h2serve = new Server();
        try {
            var s = Server.createTcpServer(params);
            s.start();
            System.out.println(s);
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:8081/gemlite_manager2;USER=gemlite");
            System.out.println(conn);
            conn.close();
            Thread.sleep(Long.MAX_VALUE);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
