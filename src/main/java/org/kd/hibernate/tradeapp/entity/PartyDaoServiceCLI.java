package org.kd.hibernate.tradeapp.entity;

import org.kd.hibernate.tradeapp.service.PartyDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PartyDaoServiceCLI implements CommandLineRunner {

    @Autowired
    private PartyDaoService partyDaoService;

    private static final Logger log = LoggerFactory.getLogger(PartyDaoServiceCLI.class);

    @Override
    public void run(String... args) throws Exception {
        var party = new Party();
        long id = partyDaoService.insert(party);
        log.info("new user created " + party);
    }

    public PartyDaoService getPartyDaoService() {
        return partyDaoService;
    }


}
