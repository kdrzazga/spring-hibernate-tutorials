package org.kd;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.BindException;

import static org.junit.jupiter.api.Assertions.fail;

public class SmokeTest extends BaseJpaTest {

    private static Server DB_SERVER;
    //private static Fund f;

    @BeforeAll
    public static void classSetUp() throws Exception {
        try {
            DB_SERVER =
                    Server.createTcpServer("-baseDir", "./data", "-tcpPort", "9092");
            DB_SERVER.start();
        } catch (Exception e) {
            if (e.getCause() instanceof BindException) {
                // 既に起動済かもしれないので無視
                e.getCause().printStackTrace();
            } else {
                throw e;
            }
        }
    }

    @Test
    @Disabled
    public void test() {
        fail("NOT IMPLEMENTED YET");
    }
}
