package org.kd.tradeapp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Party;
import org.kd.tradeapp.service.PartyDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PartyDaoServiceTest {

    @Autowired
    private PartyDaoService partyDaoService;

    @Test
    public void testGetAllParties() {
        var allParties = partyDaoService.getAllParties();

        Assert.assertNotNull(allParties);
        assertTrue(allParties.size() > 0);
    }

    @Test
    public void testGetSinglePartyById() {
        var party = partyDaoService.get(1012L);

        Assert.assertNotNull(party);
        assertEquals(1012L, party.getId());
    }

    @Test
    public void testGetSinglePartyByName() {
        var party = partyDaoService.get("BABA");

        Assert.assertNotNull(party);
        assertEquals("Alibaba Group Holding", party.getName());
    }

    @Test
    public void testGetAssociatedFund() {
        List<Fund> associatedFunds = partyDaoService.getAssociatedFunds(1012L);

        Assert.assertNotNull(associatedFunds);
        assertTrue(associatedFunds.size() > 0);
    }

    @Test
    public void testInsert(){
        var partyId = partyDaoService.insert(new Party("Test Party", "TEST"));
        assertEquals(partyId, partyDaoService.get("TEST").getId());
    }


    @Test
    public void testPartyUpdate(){
        var newPartyName = "NEW TEST NAME";
        var party = partyDaoService.get(1012L);
        party.setName(newPartyName);
        partyDaoService.update(party);

        var readParty = partyDaoService.get(1012L);
        assertEquals(newPartyName, readParty.getName());
    }

    @Ignore
    @Test
    public void testPersistenceAndDetach(){
        var party = new Party("Test Party 3", "TEST3");
        var partyId = partyDaoService.insert(party);
        partyDaoService.detach(party);
        assertNotEquals(partyId, partyDaoService.get("TEST3").getId());
    }

}
