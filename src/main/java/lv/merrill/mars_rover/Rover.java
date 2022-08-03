package lv.merrill.mars_rover;

import static lv.merrill.mars_rover.Direction.*;

public class Rover {
    private Grid grid;
    private Direction direction = NORTH;

    private Coordinate coordinate = new Coordinate();

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public Rover() {
        this(new Grid(10));
    }

    public String execute(String command) {
        int x = coordinate.x();
        int y = coordinate.y();

        if (isInvalid(command)) {
            return x + ":" + y + ":" + direction.code();
        }
        for (int i = 0; i < command.length(); i++) {
            String singleCommand = String.valueOf(command.charAt(i));
            if ("R".equals(singleCommand)) {
                direction = direction.right();
            }
            if ("L".equals(singleCommand)) {
                direction = direction.left();
            }
            if ("M".equals(singleCommand)) {
                if (NORTH.equals(direction)) {
                    y++;
                    y %= grid.getWidth();
                }
                if (SOUTH.equals(direction)) {
                    if (y == 0) {
                        y = grid.getWidth() - 1;
                    } else {
                        y--;
                    }
                }
                if (EAST.equals(direction)) {
                    x++;
                    x %= grid.getWidth();
                }
                if (WEST.equals(direction)) {
                    if (x == 0) {
                        x = grid.getWidth() - 1;
                    } else {
                        x--;
                    }
                }
            }
            coordinate = new Coordinate(x, y);
        }
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.code();
    }

    private boolean isInvalid(String command) {
        return command == null || command.isEmpty();
    }
}
