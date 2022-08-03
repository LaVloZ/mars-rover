package lv.merrill.mars_rover;

public class BlockedState implements State {
    private final State state;

    public BlockedState(State state) {
        this.state = state;
    }

    @Override
    public State right() {
        return this;
    }

    @Override
    public State left() {
        return this;
    }

    @Override
    public State move() {
        return this;
    }

    @Override
    public String toString() {
        return "O:" + state;
    }
}
