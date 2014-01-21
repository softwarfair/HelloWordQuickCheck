package org.softwarfair.quickcheck;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        validate(height, width);
        this.height = height;
        this.width = width;
    }

    private void validate(long x, long y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Does not exists Rectangles with negative sides ["+x+","+y+"]" );
        }

        if (x > Integer.MAX_VALUE || y > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Rectangle side cannot be bigger than " + Integer.MAX_VALUE);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public long area(){
        return height * width;
    }

    public boolean isSquare() {
        return height == width;
    }

    public boolean biggerThan(Rectangle that) {
        return area() > that.area();
    }

    public void add(int n) {
        validate(height +n, width +n);
        this.height = height +n;
        this.width = width +n;
    }

    public double hypotenuse() {
        return Math.sqrt(Math.pow(height,2)+Math.pow(width,2));
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", height, width);
    }
}
