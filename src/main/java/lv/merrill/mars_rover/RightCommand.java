package lv.merrill.mars_rover;

public class RightCommand implements Command {
    @Override
    public State execute(State state) {
        return state.right();
    }
}
