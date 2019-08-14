package org.kd.springboot.springrest.tictactoe.contoller;

import org.kd.springboot.HtmlPageBuilder;
import org.kd.springboot.springrest.demo.client.CommonUtility;
import org.kd.springboot.springrest.demo.server.config.RestTemplateConfig;
import org.kd.springboot.springrest.tictactoe.model.TicTacToeLogic;
import org.kd.springboot.springrest.tictactoe.model.TicTacToeMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Import(RestTemplateConfig.class)
public class TttControler {

    //@Value("server.port")
    private String port = "8083";

    //@Value("server.url")
    private String url = "http://localhost:8083/";

    @Autowired
    private CommonUtility commonUtility;

    private TicTacToeLogic logic = new TicTacToeLogic();

    @GetMapping(path = "/place/{x},{y}")
    public String checkTttField(@PathVariable("x") Character x,
                                @PathVariable("y") Character y) {

        var output = new HtmlPageBuilder();
        String userName = extractUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        sendMoveToServer(x, y, userName);

        output
                .withTitle("Tic Tac Toe")
                .withParagraph(userName)
                .withParagraph("(" + x + ", " + y + ")")
                .withTable(logic.getTable().getContent())
                .withLink("http://localhost:" + port + "/logout", "logout");
        return output.build();
    }

    @PostMapping(path = "/sendMove")
    public ResponseEntity<TicTacToeTable> acceptMove(@RequestBody TicTacToeMove move) {

        int row = Integer.parseInt(move.getX());
        int col = Integer.parseInt(move.getY());
        String player = move.getUserName().substring(move.getUserName().length() - 1);

        if (player.endsWith("x")) {
            logic.getTable().putX(row, col);
        } else {
            logic.getTable().putO(row, col);
        }

        return ResponseEntity.ok()
                .body(logic.getTable());
    }

    private void sendMoveToServer(Character x, Character y, String userName) {
        try {
            var requestAsString = "{\"x\":\"" + x + "\", \"y\":\"" + y + "\", \"move\":\"" + userName + "\"}";

            var response = commonUtility.processHttpRequest(HttpMethod.POST, requestAsString, this.url + "sendMove", "application/json");

        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }

    }

    private String extractUserName(Object principalAuth) {
        return principalAuth.toString();
    }
}
