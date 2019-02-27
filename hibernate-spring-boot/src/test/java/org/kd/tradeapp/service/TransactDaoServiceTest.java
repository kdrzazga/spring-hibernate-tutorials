package org.kd.tradeapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.TradeApplication;
import org.kd.tradeapp.entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Predicate;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@SpringBootTest(classes = {TradeApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactDaoServiceTest {

    @Autowired
    private TransactDaoService transactDaoService;

    @Autowired
    private FundDaoService fundDaoService;

    @Test
    public void testGetTransactByPrimaryKey() {
        assertEquals(3002, transactDaoService.getTransactByPrimaryKey(3002).getId());
        assertEquals(3003, transactDaoService.getTransactByPrimaryKey(3003).getId());
        assertEquals(3005, transactDaoService.getTransactByPrimaryKey(3005).getId());
    }

    @Test
    public void testRemoveTransactByPrimaryKey() {
        transactDaoService.removeTransactByPrimaryKey(3006);
        Assert.assertNull(transactDaoService.getTransactByPrimaryKey(3006));
        transactDaoService.book(2003, 2004, 30.02f);//books transact again, but id will change
    }

    @Test
    public void testGetTransactsForParticularFund() {
        var transactionsForFund2002 = transactDaoService.getTransactByFundId(2002);
        Assert.assertNotNull(transactionsForFund2002);
        assertEquals(3, transactionsForFund2002.size());
    }

    @Test
    public void testGetAllTransacts() {
        var transacts = transactDaoService.getAllTransacts();

        Assert.assertNotNull(transacts);
        assertThat(transacts, hasSize(greaterThan(0)));
        assertEquals(6, transacts.size());
    }

    @Test
    public void testBookInternalTransact() {
        int srcFundId = 2002;
        var commonPartyId = fundDaoService.get(srcFundId).getParty_id();

        checkBookingTransact(srcFundId, fund -> fund.getParty_id() == commonPartyId);
    }

    @Test
    public void testBookExternalTransact() {
        int srcFundId = 2011;
        var commonPartyId = fundDaoService.get(srcFundId).getParty_id();

        checkBookingTransact(srcFundId, fund -> fund.getParty_id() != commonPartyId);
    }

    private void checkBookingTransact(int srcFundId, Predicate<Fund> partyIdComparisonPredicate) {

        var destFund = fundDaoService.getAllFunds()
                .stream()
                .filter(partyIdComparisonPredicate)
                .findFirst();

        if (!destFund.isPresent())
            fail("Wrong test data. Cannot book Transact. Only one fund with appropriate party id ");

        final int errorCode = -1;
        final int newTransactId =  transactDaoService.book(srcFundId, destFund.get().getId(), 0.5f);

        assertNotEquals(errorCode, newTransactId);

        removeBookedTransact(newTransactId);
    }

    private void removeBookedTransact(int id) {
        transactDaoService.removeTransactByPrimaryKey(id);
    }

}
