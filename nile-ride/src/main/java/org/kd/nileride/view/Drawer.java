package org.kd.nileride.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.kd.nileride.common.CyclicList;
import org.kd.nileride.model.Board;
import org.kd.nileride.model.Track;
import org.kd.nileride.model.Vehicle;

import java.util.stream.IntStream;

public class Drawer {

    private GraphicsContext gc;

    private final Color DEFAULT_COLOR = Color.BLUE;
    private final Color BANK_COLOR = Color.BROWN;
    private final Color GRASS_COLOR = Color.GREEN;

    public Drawer(GraphicsContext gc) {
        this.gc = gc;
    }

    public void draw(Board board) {
        gc.setFill(DEFAULT_COLOR);
        gc.fillRect(0, 0, Board.WIDTH, Board.HEIGHT);

        draw(board.getVehicle());
        drawEnemy(board.getEnemy());
        draw(board.getTrack());
    }

    private void draw(Track track) {
        drawBank(track.getLeftBank(), 0.0);
        drawBank(track.getRightBank(), Board.WIDTH);
    }

    private void drawBank(CyclicList<Integer> points, double edge) {
        double x1 = computeX(points, 0);
        double y1 = 0;

        var iterator = IntStream.range(0, Board.HEIGHT).iterator();
        gc.setLineWidth(2);

        while (iterator.hasNext()) {
            var h = iterator.nextInt();
            double x2 = computeX(points, h);
            double y2 = 9 * h / 1.0;
            gc.setStroke(BANK_COLOR);
            gc.strokeLine(x1, y1, x2, y2);

            gc.setFill(GRASS_COLOR);
            double[] grassPolygonX = {edge, x1, x2, edge};
            double[] grassPolygonY = {y1, y1, y2, y2};
            gc.fillPolygon(grassPolygonX, grassPolygonY, grassPolygonX.length);
            x1 = x2;
            y1 = y2;
        }
        gc.setStroke(DEFAULT_COLOR);
    }

    private double computeX(CyclicList<Integer> points, int h) {
        double percent = points.get(h) / 100f;
        return (int) (percent * Board.WIDTH);
    }

    public void drawEnemy(Vehicle enemy) {
        gc.strokeRoundRect(enemy.getX(), 60 - enemy.getY(), 30, 30, 10, 10);
    }

    public void draw(Vehicle vehicle) {
        var vx = vehicle.getX() * Board.WIDTH / 100;
        var vy = vehicle.getY() * Board.HEIGHT / 100;
        var width = vehicle.getWIDTH() * Board.WIDTH / 100;
        var height = vehicle.getHEIGHT() * Board.HEIGHT / 100;

        gc.setFill(Color.YELLOW);
        gc.setLineWidth(3);
        gc.fillOval(vx - 5, vy + 5, width, height);
    }

    public GraphicsContext getGc() {
        return gc;
    }
}
