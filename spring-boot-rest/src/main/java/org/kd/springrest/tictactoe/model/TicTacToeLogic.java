package org.kd.springrest.tictactoe.model;


import org.kd.springrest.tictactoe.contoller.TicTacToeTable;

public class TicTacToeLogic {

    private TicTacToeTable table = new TicTacToeTable();

    public TicTacToeTable getTable() {
        table.putX(1, 2);
        table.putO(0, 2);
        return table;
    }

}
