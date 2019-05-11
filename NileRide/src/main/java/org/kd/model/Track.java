package org.kd.model;

import org.kd.common.CyclicList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Track {

    //both banks of the river expressed in percentage of screen width
    private static List<Integer> leftBankData = Arrays.asList(40, 39, 39, 38, 37, 39, 39, 37, 39, 39, 38, 39, 39, 38, 37, 36, 34, 34, 30, 30, 30, 28, 28, 22, 25, 26, 27, 28, 29, 30, 30, 29, 29, 28, 28, 27, 27, 28);
    private static List<Integer> rightBankData = Arrays.asList(60, 59, 59, 58, 57, 59, 59, 59, 59, 57, 59, 58, 57, 57, 57, 60, 60, 60, 58, 58, 55, 55, 55, 54, 54, 53, 51, 49, 49, 48, 48, 47, 47, 50, 55, 58, 62, 63);

    private CyclicList<Integer> leftBank;
    private CyclicList<Integer> rightBank;

    public Track() {
        this.leftBank = new CyclicList<>(leftBankData.size());
        leftBank.addAll(leftBankData);
        this.rightBank = new CyclicList<>(rightBankData.size());
        rightBank.addAll(rightBankData);
    }

    public void move() {
        leftBank.shiftRight();
        rightBank.shiftRight();
    }

    /**
     * negative value - move left, positive - move right
     * returns true if success
     */
    public boolean moveBanks(int percent) {
        var iterator = leftBank.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() + percent < 0
                    || (iterator.next() + percent > Board.WIDTH))
                return false;
        }

        iterator = rightBank.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() + percent < 0
                    || (iterator.next() + percent > Board.WIDTH))
                return false;
        }

        IntStream.range(0, leftBank.size())
                .forEach(i -> leftBank.set(i, leftBank.get(i) + percent));

        IntStream.range(0, rightBank.size())
                .forEach(i -> rightBank.set(i, rightBank.get(i) + percent));

        return true;
    }

    public CyclicList<Integer> getLeftBank() {
        return leftBank;
    }

    public CyclicList<Integer> getRightBank() {
        return rightBank;
    }


}
