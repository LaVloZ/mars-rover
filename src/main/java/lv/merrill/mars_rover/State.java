package lv.merrill.mars_rover;

public interface State {
    State right();

    State left();

    State move();
}
