package org.kd.hibernatewithspring.tradeapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.hibernate.tradeapp.Application;
import org.kd.hibernate.tradeapp.service.PartyDaoService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PartyDaoServiceTest {

    @Mock
    Application app;

    @Autowired
    private PartyDaoService userDaoService;

    @Test
    public void testPartyReading(){
        app.main(new String[0]);//whether application is mocked or not, execuition of main is the same

        var allParties = userDaoService.getAllParties();

        assertNotNull(allParties);
        assertTrue(allParties.size() > 0);
    }

}
