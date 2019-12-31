package org.kd.userapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = {UserApplication.class})
@ExtendWith(SpringExtension.class)
public class UserDaoServiceCliTest {

    @Autowired
    private UserDaoServiceCLI userDaoServiceCLI;

    @Test
    public void testContextLoaded() {
        Assert.assertNotNull(userDaoServiceCLI);
    }

    @Test
    public void testFetchingUser(){
        assertEquals(1L, userDaoServiceCLI.getUserFromDao().getId());
    }
}
