package org.kd.hibernatewithspring.userapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.hibernate.userapp.Application;
import org.kd.hibernate.userapp.UserDaoServiceCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoServiceCliTest {

    @Autowired
    private UserDaoServiceCLI userDaoServiceCLI;

    @Test
    public void testContextLoaded() {
        assertNotNull(userDaoServiceCLI);
    }

    @Test
    public void testFetchingUser(){
        assertEquals(1L, userDaoServiceCLI.getUserFromDao().getId());
    }
}
