package tsp;

public class Point {

    private int x,y,number;

    public Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return (number + " ");
    }
}
