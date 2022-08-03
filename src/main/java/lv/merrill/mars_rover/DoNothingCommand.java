package lv.merrill.mars_rover;

public class DoNothingCommand implements Command {
    @Override
    public State execute(State state) {
        return state;
    }
}
