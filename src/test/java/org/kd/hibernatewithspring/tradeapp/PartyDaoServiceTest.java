package org.kd.hibernatewithspring.tradeapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.hibernate.tradeapp.Application;
import org.kd.hibernate.tradeapp.entity.PartyDaoServiceCLI;
import org.kd.hibernate.tradeapp.service.PartyDaoService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PartyDaoServiceTest {

    @Autowired
    private PartyDaoService userDaoService;

    @Test
    public void testParty(){
        Application.main(new String[0]);// TODO: try to mock application run

        var allParties = userDaoService.get();

        assertNotNull(allParties);
        assertTrue(allParties.size() > 0);
    }

}
