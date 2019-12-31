package org.kd.tradeapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.tradeapp.TradeApplication;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@SpringBootTest(classes = {TradeApplication.class})
@ExtendWith(SpringExtension.class)
public class FundDaoServiceTest {

    @Autowired
    private FundDaoService fundDaoService;

    @Test
    public void testGetAllFunds() {
        var allFunds = fundDaoService.getAllFunds();

        Assert.assertNotNull(allFunds);
        assertTrue(allFunds.size() > 0);
    }

    @Test
    public void testGetSingleFundById() {
        var fund = fundDaoService.get(2002L);

        Assert.assertNotNull(fund);
        assertEquals(2002L, fund.getId().longValue());
    }

    @Test
    public void testGetSingleFundByName() {
        var fund = fundDaoService.get("RAD");

        Assert.assertNotNull(fund);
        assertEquals("Rite Aid Corp", fund.getName());
    }

    @Test
    public void testFundUpdate(){
        var newFundName = "NEW TEST NAME";
        var fund = fundDaoService.get(2001L);
        fund.setName(newFundName);
        fundDaoService.update(fund);

        var readFund = fundDaoService.get(2001L);
        assertEquals(newFundName, readFund.getName());
    }

    @Test
    public void testInsert(){
        var fundId = fundDaoService.insert(new Fund( "TEST3", "Test Fund", 2, new Party("Test", "tst")));
        assertEquals(fundId, fundDaoService.get("TEST3").getId().longValue());
    }

    @Test
    public void testGetAssociatedPartyWithManyTo1Mapping(){
        var fund = fundDaoService.get(2001L);
        assertNotNull(fund.getParty());
        assertEquals(1001L, fund.getParty().getId());
    }
}
