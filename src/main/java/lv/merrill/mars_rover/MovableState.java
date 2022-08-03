package lv.merrill.mars_rover;

public final class MovableState implements State {
    private final Coordinate coordinate;

    private final Direction direction;
    private final Grid grid;

    public MovableState(Coordinate coordinate, Direction direction, Grid grid) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.grid = grid;
    }

    @Override
    public State right() {
        Direction right = direction.right();
        return new MovableState(coordinate, right, grid);
    }

    @Override
    public State left() {
        Direction left = direction.left();
        return new MovableState(coordinate, left, grid);
    }

    @Override
    public State move() {
        Coordinate nextCoordinate = direction.move(coordinate, grid);
        if (!grid.isReachableAt(nextCoordinate)) {
            return new BlockedState(this);
        }
        return new MovableState(nextCoordinate, direction, grid);
    }

    @Override
    public String toString() {
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.code();
    }
}
