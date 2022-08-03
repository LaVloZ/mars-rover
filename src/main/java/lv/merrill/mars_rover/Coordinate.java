package lv.merrill.mars_rover;

public final class Coordinate {
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private final int x;
    private final int y;

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
