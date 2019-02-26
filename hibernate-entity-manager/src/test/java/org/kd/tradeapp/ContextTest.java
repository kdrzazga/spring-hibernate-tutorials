package org.kd.tradeapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.service.FundDaoService;
import org.kd.tradeapp.service.PartyDaoService;
import org.kd.tradeapp.service.TransactDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = {TradeApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContextTest {

    @Autowired
    private TransactDaoService transactDaoService;

    @Autowired
    private PartyDaoService partyDaoService;

    @Autowired
    private FundDaoService fundDaoService;

    @Test
    public void testTransactDaoServiceInjection() {
        assertNotNull(transactDaoService);
    }

    @Test
    public void testPartyDaoServiceInjection() {
        assertNotNull(partyDaoService);
    }

    @Test
    public void testFundDaoServiceInjection() {
        assertNotNull(fundDaoService);
    }
}
