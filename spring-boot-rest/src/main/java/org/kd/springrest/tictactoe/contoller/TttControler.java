package org.kd.springrest.tictactoe.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TttControler {

    @GetMapping(path = "/{x},{y}")
    public String checkTttField(@PathVariable("x") Character x,
                                  @PathVariable("y") Character y) {

        return "(" + x + ", " + y + ")";
    }
}
