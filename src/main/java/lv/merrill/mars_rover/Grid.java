package lv.merrill.mars_rover;

import java.util.Set;

import static java.util.Collections.emptySet;

public class Grid {
    private int width;
    private Set<Coordinate> obstacles = emptySet();

    public Grid(int width) {
        this.width = width;
    }

    public Grid(int width, Set<Coordinate> obstacles) {
        this.width = width;
        this.obstacles = obstacles;
    }

    public int getWidth() {
        return width;
    }

    public boolean isReachableAt(Coordinate coordinate) {
        return !obstacles.contains(coordinate);
    }
}
