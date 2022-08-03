package lv.merrill.mars_rover;

public class LeftCommand implements Command {
    @Override
    public State execute(State state) {
        return state.left();
    }
}
