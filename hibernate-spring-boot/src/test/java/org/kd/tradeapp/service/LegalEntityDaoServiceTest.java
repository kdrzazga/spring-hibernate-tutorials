package org.kd.tradeapp.service;

import org.junit.runner.RunWith;
import org.kd.tradeapp.TradeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {TradeApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LegalEntityDaoServiceTest {

  /*  @Autowired
    private LegalEntityService legalEntityDaoService;

    @Test
    public void testGetSingleLegalEntityById() {
        var legalEntity = legalEntityDaoService.get(4001L);

        Assert.assertNotNull(legalEntity);
        assertEquals(4001L, legalEntity.getId());
    }
*/
}
