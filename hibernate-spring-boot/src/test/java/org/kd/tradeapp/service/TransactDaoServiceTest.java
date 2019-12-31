package org.kd.tradeapp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.tradeapp.TradeApplication;
import org.kd.tradeapp.entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Predicate;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@SpringBootTest(classes = {TradeApplication.class})
@ExtendWith(SpringExtension.class)
public class TransactDaoServiceTest {

    @Autowired
    private TransactDaoService transactDaoService;

    @Autowired
    private FundDaoService fundDaoService;

    @Test
    public void testGetTransactByPrimaryKey() {
        assertEquals(3002L, transactDaoService.getTransactByPrimaryKey(3002).getId().longValue());
        assertEquals(3003L, transactDaoService.getTransactByPrimaryKey(3003).getId().longValue());
        assertEquals(3005L, transactDaoService.getTransactByPrimaryKey(3005).getId().longValue());
    }

    @Test
    public void testRemoveTransactByPrimaryKey() {
        var transactId = 3006L;
        assertNotNull(transactDaoService.getTransactByPrimaryKey(transactId));
        transactDaoService.removeTransactByPrimaryKey(transactId);
        Assert.assertNull(transactDaoService.getTransactByPrimaryKey(transactId));
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
        long srcFundId = 2002;
        var commonPartyId = fundDaoService.get(srcFundId).getParty().getId();

        checkBookingTransact(srcFundId, fund -> fund.getParty().getId() == commonPartyId);
    }

    @Test
    public void testBookExternalTransact() {
        long srcFundId = 2011L;
        var commonPartyId = fundDaoService.get(srcFundId).getParty().getId();

        checkBookingTransact(srcFundId, fund -> fund.getParty().getId() != commonPartyId);
    }

    private void checkBookingTransact(long srcFundId, Predicate<Fund> partyIdComparisonPredicate) {

        var destFund = fundDaoService.getAllFunds()
                .stream()
                .filter(partyIdComparisonPredicate)
                .findFirst();

        if (!destFund.isPresent())
            fail("Wrong test data. Cannot book Transact. Only one fund with appropriate party id ");

        final int errorCode = -1;
        final long newTransactId =  transactDaoService.book(srcFundId, destFund.get().getId(), 0.5f);

        assertNotEquals(errorCode, newTransactId);

        removeBookedTransact(newTransactId);
    }

    private void removeBookedTransact(long id) {
        transactDaoService.removeTransactByPrimaryKey(id);
    }

}
