package lv.merrill.mars_rover;

import java.util.HashSet;

public class Grid {
    private int width;
    private HashSet<Coordinate> obstacles;

    public Grid(int width) {
        this.width = width;
    }

    public Grid(int width, HashSet<Coordinate> obstacles) {
        this.width = width;
        this.obstacles = obstacles;
    }

    public int getWidth() {
        return width;
    }
}
