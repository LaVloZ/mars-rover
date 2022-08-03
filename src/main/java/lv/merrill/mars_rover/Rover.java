package lv.merrill.mars_rover;

import static lv.merrill.mars_rover.Direction.NORTH;

public class Rover {
    private State state;

    public Rover(Grid grid) {
        this.state = new MovableState(new Coordinate(), NORTH, grid);
    }

    public Rover() {
        this(new Grid(10));
    }

    public String execute(String command) {

        if (isInvalid(command)) {
            return state.toString();
        }
        for (int i = 0; i < command.length(); i++) {
            String singleCommand = String.valueOf(command.charAt(i));
            if ("R".equals(singleCommand)) {
                state = state.right();
            }
            if ("L".equals(singleCommand)) {
                state = state.left();
            }
            if ("M".equals(singleCommand)) {
                state = state.move();
            }
        }
        return state.toString();
    }

    private boolean isInvalid(String command) {
        return command == null || command.isEmpty();
    }
}
