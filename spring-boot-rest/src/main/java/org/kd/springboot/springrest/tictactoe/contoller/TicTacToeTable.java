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

    public boolean isCellAvailable(int row, int col) {
        return (row < table[0].length && row < table.length) && (table[row][col] == ' ' || table[row][col] == ' ');
    }

    char[][] getContent(){
        return table;
    }
}
