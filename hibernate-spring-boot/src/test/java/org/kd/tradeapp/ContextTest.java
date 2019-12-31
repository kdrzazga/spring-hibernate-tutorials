package org.kd.tradeapp;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.tradeapp.service.FundDaoService;
import org.kd.tradeapp.service.PartyDaoService;
import org.kd.tradeapp.service.TransactDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = {TradeApplication.class})
@ExtendWith(SpringExtension.class)
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
