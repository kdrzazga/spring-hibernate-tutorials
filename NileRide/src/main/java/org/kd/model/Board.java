package org.kd.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Board {

    private Vehicle vehicle;
    public int mapPosition;
    private BoardKeyListener boardKeyListener;

    private GraphicsContext gc;
    private final Image img;

    public Board(GraphicsContext gc) {
        this.gc = gc;
        img = new Image("file:C:\\Users\\KDRZAZGA\\Documents\\programming\\gm\\src\\main\\resources\\backgnd.png");
    }

    public void drawAllVehicles() {
        gc.clearRect(0, 0, 500, 500);

        //gc.drawImage(img, 0, mapPosition);
        vehicle.x += 4;
        vehicle.y -= 3;
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        //gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(vehicle.x - 5, vehicle.y + 5, 10, 10);
        /*gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);*/
        gc.strokeRoundRect(70, 60 - vehicle.y, 30, 30, 10, 10);
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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setBoardKeyListener(BoardKeyListener boardKeyListener) {
        this.boardKeyListener = boardKeyListener;
    }

}
