package lv.merrill.mars_rover;

import static lv.merrill.mars_rover.Direction.*;

public class Rover {
    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public Rover() {
        this(new Grid(10));
    }

    public String execute(String command) {
        Direction direction = NORTH;
        int yAxis = 0;
        int xAxis = 0;
        if (isInvalid(command)) {
            return xAxis + ":" + yAxis + ":" + direction.code();
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
                    yAxis++;
                    yAxis %= grid.getWidth();
                }
                if (SOUTH.equals(direction)) {
                    if (yAxis == 0) {
                        yAxis = grid.getWidth() - 1; // 0:0:W + M
                        continue;
                    }
                    yAxis--;
                }
                if (EAST.equals(direction)) {
                    xAxis++;
                }
                if (WEST.equals(direction)) {
                    if (xAxis == 0) {
                        xAxis = grid.getWidth() - 1; // 0:0:W + M
                        continue;
                    }
                    xAxis--;
                }
            }
        }
        return xAxis + ":" + yAxis + ":" + direction.code();
    }

    private boolean isInvalid(String command) {
        return command == null || command.isEmpty();
    }
}
