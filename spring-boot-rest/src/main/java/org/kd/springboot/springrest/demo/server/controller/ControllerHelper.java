package org.kd.springboot.springrest.demo.server.controller;

import java.sql.Timestamp;
import java.util.Date;

class ControllerHelper {

    private int initialId = 100;

    String generateId() {
        initialId++;

        var date = new Date();
        var ts = new Timestamp(date.getTime());
        return Long.valueOf(initialId).toString() + ts.getTime();
    }
}
