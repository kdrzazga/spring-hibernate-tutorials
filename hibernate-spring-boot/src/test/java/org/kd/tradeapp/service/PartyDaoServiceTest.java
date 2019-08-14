package org.kd.tradeapp.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.TradeApplication;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@SpringBootTest(classes = {TradeApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PartyDaoServiceTest {

    @Autowired
    private PartyDaoService partyDaoService;

    @Test
    public void testGetAllParties() {
        var allParties = partyDaoService.getAllParties();

        assertNotNull(allParties);
        assertTrue(allParties.size() > 0);
    }

    @Test
    public void testGetSinglePartyById() {
        var party = partyDaoService.get(1001L);

        assertNotNull(party);
        assertEquals(1001L, party.getId());
    }

    @Test
    public void testGetSinglePartyByName() {
        var party = partyDaoService.get("AAC");

        assertNotNull(party);
        assertEquals("Aac Holdings Inc", party.getName());
    }

    @Test
    public void testGetAssociatedFundsByFundMapping() {
        long partyId = 1001L;
        List<Fund> associatedFunds = partyDaoService.getAssociatedFunds(partyId);

        assertNotNull(associatedFunds);
        assertThat(associatedFunds, hasSize(greaterThan(0)));
        assertEquals(partyId, associatedFunds.get(0).getParty().getId());
    }

    @Test
    public void testInsert() {
        var partyId = partyDaoService.insert(new Party("Test Party", "TEST"));
        assertEquals(partyId, partyDaoService.get("TEST").getId());
    }

    @Test
    public void testPartyUpdate() {
        var newPartyName = "NEW TEST NAME";
        var party = partyDaoService.get(1002L);
        party.setName(newPartyName);
        partyDaoService.update(party);

        var readParty = partyDaoService.get(1002L);
        assertEquals(newPartyName, readParty.getName());
    }

    @Ignore
    @Test
    public void testPersistenceAndRemoval() {
        var party = new Party("Test Party 3", "TEST3");
        var partyId = partyDaoService.insert(party);

        partyDaoService.remove(party);
        assertEquals(partyId, partyDaoService.get("TEST3").getId());
    }

    @Test
    public void testGetAvailableFundsFromManyToOneMapping() {
        var party = partyDaoService.get(1001L);

        assertNotNull(party.getAvailableFunds());
    }
}
