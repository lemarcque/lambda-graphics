package sample.environment.geometry.euclide;

public class Point {

    private String name;
    CartesianCoordinate coordinate;                         // cartesian coordinate system of the point

    public Point(int posX, int posY) {
        coordinate = new CartesianCoordinate(posX, posY);
    }

    public Point(CartesianCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getPosX() {
        return coordinate.x;
    }

    public int getPosY() {
        return coordinate.y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
