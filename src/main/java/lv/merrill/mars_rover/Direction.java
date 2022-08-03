package lv.merrill.mars_rover;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Coordinate move(final Coordinate coordinate, final Grid grid) {
            return coordinate.incrementY(grid);
        }
    }, EAST("E") {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Coordinate move(Coordinate coordinate, Grid grid) {
            return coordinate.incrementX(grid);
        }
    }, SOUTH("S") {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Coordinate move(Coordinate coordinate, Grid grid) {
            return coordinate.decrementY(grid);
        }
    }, WEST("W") {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Coordinate move(Coordinate coordinate, Grid grid) {
            return coordinate.decrementX(grid);
        }
    };

    private final String code;

    Direction(String code) {
        this.code = code;
    }

    abstract public Direction right();

    abstract public Direction left();

    abstract public Coordinate move(final Coordinate coordinate, final Grid grid);

    String code() {
        return code;
    }
}
