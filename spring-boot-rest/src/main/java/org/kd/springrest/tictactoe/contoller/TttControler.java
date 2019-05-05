package org.kd.springrest.tictactoe.contoller;

import org.kd.springrest.tictactoe.model.TicTacToeLogic;
import org.kd.springrest.tictactoe.model.TicTacToeMove;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springsecurity.sample.config.HtmlPageBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TttControler {

    //@Value("server.port")
    private String port = "8083";

    //@Value("server.url")
    private String url = "http://localhost:8083/";

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
    public TicTacToeTable acceptMove(@RequestBody TicTacToeMove move) {

        int row = Integer.parseInt(move.getX());
        int col = Integer.parseInt(move.getY());

        logic.getTable().putX(row, col);
        return logic.getTable();
    }

    private void sendMoveToServer(Character x, Character y, String userName) {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.TEXT_PLAIN);
        try {
            RequestEntity<TicTacToeMove> moveRequest = RequestEntity.post(new URI(this.url + "sendMove"))
                    .accept(MediaType.APPLICATION_JSON)
                    .body(new TicTacToeMove(x.toString(), y.toString(), userName));

            restTemplate.exchange(moveRequest, TicTacToeTable.class);

        } catch (HttpClientErrorException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private String extractUserName(Object principalAuth) {
        return principalAuth.toString();
    }
}
