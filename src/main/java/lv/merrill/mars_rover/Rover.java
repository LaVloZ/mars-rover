package lv.merrill.mars_rover;

import static lv.merrill.mars_rover.Direction.EAST;
import static lv.merrill.mars_rover.Direction.NORTH;

public class Rover {
    public Rover(Grid grid) {
    }

    public Rover() {
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
                }
                if (EAST.equals(direction)) {
                    xAxis++;
                }
            }
        }
        return xAxis + ":" + yAxis + ":" + direction.code();
    }

    private boolean isInvalid(String command) {
        return command == null || command.isEmpty();
    }
}
