package org.kd.springboot.springrest.tictactoe.contoller;

public class TicTacToeTable {
    private char[][] table = new char[3][3];

    public String get(int row, int col) {
        return table[row][col] + "";
    }

    public void putX(int row, int col) {
        table[row][col] = 'x';
    }

    public void putO(int row, int col) {
        table[row][col] = 'o';
    }

    char[][] getContent(){
        return table;
    }
}
