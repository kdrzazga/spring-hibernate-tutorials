package org.kd.springboot.springrest.tictactoe.model;


import org.kd.springboot.springrest.tictactoe.contoller.TicTacToeTable;

public class TicTacToeLogic {

    private TicTacToeTable table = new TicTacToeTable();

    public TicTacToeTable getTable() {
        table.putX(1, 2);
        table.putO(0, 2);
        return table;
    }

}
