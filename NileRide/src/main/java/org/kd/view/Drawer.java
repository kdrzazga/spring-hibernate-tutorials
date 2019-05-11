package org.kd.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.kd.common.CyclicList;
import org.kd.model.Board;
import org.kd.model.Track;
import org.kd.model.Vehicle;

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
            //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
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
        //System.out.println(points.get(h) + " " + (int) (percent * Board.WIDTH));
        return (int) (percent * Board.WIDTH);
    }

    public void drawEnemy(Vehicle enemy)
    {
        gc.strokeRoundRect(enemy.getX(), 60 - enemy.getY(), 30, 30, 10, 10);
    }

    public void draw(Vehicle vehicle) {

        gc.setFill(Color.YELLOW);

        var vx = vehicle.getX();
        var vy = vehicle.getY();
        //List<Double> x = List.of(vehicle.);
        gc.setLineWidth(3);

        //gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(vehicle.getX() - 5, vehicle.getY() + 5, 10, 10);
        /*gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);*/

        /*gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
*/
    }

    public GraphicsContext getGc() {
        return gc;
    }
}
