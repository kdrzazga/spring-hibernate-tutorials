package org.kd;

import org.h2.Driver;
import org.h2.store.fs.FileUtils;
import org.h2.tools.DeleteDbFiles;
import org.h2.tools.Server;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kd.entity.Fund;

import java.net.BindException;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class SmokeTest extends BaseJpaTest{

    private static Server DB_SERVER;
    private static Fund f;

    @BeforeClass
    public static void classSetUp() throws Exception {
        try {
            DB_SERVER =
                    Server.createTcpServer(new String[]{ "-baseDir", "./data", "-tcpPort", "9092" });
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
    public void test(){
        fail("NOT IMPLEMENTED YET");
    }
}
