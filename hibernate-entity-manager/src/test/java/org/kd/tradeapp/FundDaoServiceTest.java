package org.kd.tradeapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Party;
import org.kd.tradeapp.service.FundDaoService;
import org.kd.tradeapp.service.PartyDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
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
        var fund = fundDaoService.get(2012L);

        Assert.assertNotNull(fund);
        assertEquals(2012L, fund.getId());
    }

    @Test
    public void testGetSingleFundByName() {
        var fund = fundDaoService.get("LPX");

        Assert.assertNotNull(fund);
        assertEquals("Louisiana-Pacific Corp", fund.getName());
    }

    @Test
    public void testFundUpdate(){
        var newFundName = "NEW TEST NAME";
        var fund = fundDaoService.get(2012L);
        fund.setName(newFundName);
        fundDaoService.update(fund);

        var readFund = fundDaoService.get(2012L);
        assertEquals(newFundName, readFund.getName());
    }


    @Test
    public void testInsert(){
        var fundId = fundDaoService.insert(new Fund( "TEST3", "Test Fund", 2, 1001));
        assertEquals(fundId, fundDaoService.get("TEST3").getId());
    }
}
