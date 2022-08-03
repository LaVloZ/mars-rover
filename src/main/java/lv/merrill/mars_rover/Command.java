package lv.merrill.mars_rover;

public interface Command {
    State execute(final State state);
}
