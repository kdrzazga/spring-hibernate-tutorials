package org.kd.hibernatewithspring.tradeapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.hibernate.tradeapp.Application;
import org.kd.hibernate.tradeapp.service.TransactDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactDaoServiceTest {

    @Autowired
    private TransactDaoService transactDaoService;

    @Test
    public void testGetTransactByPrimaryKey() {
        assertEquals(3002, transactDaoService.getTransactByPrimaryKey(3002).getId());
        assertEquals(3003, transactDaoService.getTransactByPrimaryKey(3003).getId());
        assertEquals(3005, transactDaoService.getTransactByPrimaryKey(3005).getId());
    }

    @Test
    public void testRemoveTransactByPrimaryKey() {
        transactDaoService.removeTransactByPrimaryKey(3003);
        assertNull(transactDaoService.getTransactByPrimaryKey(3003));
    }

    @Test
    public void testGetTransactsForParticularFund() {
        var transactionsForFund2002 = transactDaoService.getTransactByFundId(2002);
        assertNotNull(transactionsForFund2002);
        assertEquals(3, transactionsForFund2002.size());
    }

    @Test
    public void testGetAllTransacts() {
        var transacts = transactDaoService.getAllTransacts();

        assertNotNull(transacts);
        assertEquals(6, transacts.size());
    }

}
