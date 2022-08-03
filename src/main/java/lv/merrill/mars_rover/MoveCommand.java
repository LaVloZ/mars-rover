package lv.merrill.mars_rover;

public class MoveCommand implements Command {
    @Override
    public State execute(State state) {
        return state.move();
    }
}
