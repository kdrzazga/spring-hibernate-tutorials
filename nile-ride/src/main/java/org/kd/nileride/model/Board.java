package org.kd.nileride.model;

public class Board {

    private Vehicle vehicle;
    private Vehicle enemy;
    private Track track;
    private BoardKeyListener boardKeyListener;

    public final static int WIDTH = 500;
    public final static int HEIGHT = 500;

    public Board() {
        track = new Track();
    }

    public void move() {
        track.move(vehicle.getSpeed());

        moveEnemy();
    }

    public boolean checkCollision(){
        return track.getLeftBank().get(0) > vehicle.getX() - vehicle.getWIDTH()/2
                || track.getRightBank().get(0) < vehicle.getX() + vehicle.getWIDTH()/2;
    }

    private void moveEnemy() {
        //TODO
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Track getTrack() {
        return track;
    }

    public void setBoardKeyListener(BoardKeyListener boardKeyListener) {
        this.boardKeyListener = boardKeyListener;
    }

    public BoardKeyListener getBoardKeyListener() {
        return boardKeyListener;
    }

    public void setEnemy(Vehicle enemy) {
        this.enemy = enemy;
    }

    public Vehicle getEnemy() {
        return enemy;
    }
}
