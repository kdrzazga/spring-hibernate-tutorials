package org.kd.model;

public class Vehicle {
    int x, y, speed;

    public Vehicle() {
        x = 70;
        y = 70;
        speed = 1;
    }

    public void accelerate() {
        speed++;
    }

    public void slowDown() {
        if (speed > 0)
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
}
