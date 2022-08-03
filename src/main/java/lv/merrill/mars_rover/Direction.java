package lv.merrill.mars_rover;

import java.util.Arrays;

public enum Direction {
    NORTH("N") {
        @Override
        Direction right() {
            return EAST;
        }
    }, EAST("E") {
        @Override
        Direction right() {
            return SOUTH;
        }
    }, SOUTH("S") {
        @Override
        Direction right() {
            return WEST;
        }
    }, WEST("W") {
        @Override
        Direction right() {
            return NORTH;
        }
    };

    private final String code;

    Direction(String code) {
        this.code = code;
    }

    static Direction of(String code) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not yet implemented"));
    }

    abstract Direction right();

    String code() {
        return code;
    }
}
