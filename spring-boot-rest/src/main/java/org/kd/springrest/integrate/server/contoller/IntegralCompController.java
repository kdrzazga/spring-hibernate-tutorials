package org.kd.springrest.integrate.server.contoller;

import org.kd.springrest.integrate.server.model.IntegralComputing;
import org.kd.springrest.integrate.server.model.WrongIntegralComputationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegralCompController {

    @GetMapping(path = "/{function}/{minX}/{maxX}")
    public String computeIntegral(@PathVariable("function") String function,
                             @PathVariable("minX") Double minX,
                             @PathVariable("maxX") Double maxX)
            throws WrongIntegralComputationException {

        return String
                .valueOf(new IntegralComputing()
                        .estimateIntegralValue(function, minX, maxX, 2_000_000));
    }
}
