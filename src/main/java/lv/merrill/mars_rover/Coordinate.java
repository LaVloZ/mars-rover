package lv.merrill.mars_rover;

import java.util.Objects;

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

    public Coordinate incrementY(final Grid grid) {
        int manipulatedY = y + 1;
        manipulatedY %= grid.getWidth();

        return new Coordinate(x, manipulatedY);
    }

    public Coordinate decrementY(final Grid grid) {
        int manipulatedY = y;
        if (y == 0) {
            manipulatedY = grid.getWidth() - 1;
        } else {
            manipulatedY--;
        }

        return new Coordinate(x, manipulatedY);
    }

    public Coordinate incrementX(final Grid grid) {
        int manipulatedX = x + 1;
        manipulatedX %= grid.getWidth();

        return new Coordinate(manipulatedX, y);
    }

    public Coordinate decrementX(final Grid grid) {
        int manipulatedX = x;
        if (x == 0) {
            manipulatedX = grid.getWidth() - 1;
        } else {
            manipulatedX--;
        }

        return new Coordinate(manipulatedX, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static Coordinate initialPoint() {
        return new Coordinate(0, 0);
    }
}
