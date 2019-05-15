package org.kd.nileride.model;

public class Vehicle {
    private int x, y, speed;
    private final int MIN_SPEED = 0;
    private final int MAX_SPEED = 3;
    private final double WIDTH = 1.5;
    private final double HEIGHT = 2.5;

    public void accelerate() {
        if (speed < MAX_SPEED) {
            speed++;
        }
    }

    public void slowDown() {
        if (speed > MIN_SPEED)
            speed--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }
}
