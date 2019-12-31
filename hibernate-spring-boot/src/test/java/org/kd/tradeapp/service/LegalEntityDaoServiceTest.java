package org.kd.tradeapp.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.tradeapp.TradeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {TradeApplication.class})
@ExtendWith(SpringExtension.class)
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
