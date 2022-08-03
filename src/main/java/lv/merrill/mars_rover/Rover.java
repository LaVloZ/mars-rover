package lv.merrill.mars_rover;

import static lv.merrill.mars_rover.Direction.NORTH;

public class Rover {
    private final State state;

    public Rover(Grid grid) {
        this.state = new MovableState(new Coordinate(), NORTH, grid);
    }

    public Rover() {
        this(new Grid(10));
    }

    public String execute(String command) {
        return Commands.of(command)
                .execute(state)
                .toString();
    }
}
