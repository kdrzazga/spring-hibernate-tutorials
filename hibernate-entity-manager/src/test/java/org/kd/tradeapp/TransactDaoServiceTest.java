package org.kd.tradeapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.tradeapp.service.TransactDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        Assert.assertNull(transactDaoService.getTransactByPrimaryKey(3003));
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
        assertEquals(6, transacts.size());
    }

    @Test
    public void testBook(){
        assertTrue(transactDaoService.book(1011L, 2002L, 0.5f));
    }

}
