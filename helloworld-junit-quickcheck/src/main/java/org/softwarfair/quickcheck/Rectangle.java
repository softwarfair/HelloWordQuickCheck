package org.softwarfair.quickcheck;

public class Rectangle {
    private int x;
    private int y;

    public Rectangle(int x, int y) {
        if ((!(x >= 0 && y >= 0))) throw new IllegalArgumentException("Does not exists Rectangles with negative sides");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long area(){
        return x*y;
    }

    public boolean isSquare() {
        return x == y;
    }
}
