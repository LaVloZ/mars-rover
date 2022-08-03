package lv.merrill.mars_rover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RoverTest {
    @Nested
    public class Acceptance {
        @Test
        public void should_be_blocked_at_9_2_W() {
            Grid grid = new Grid(10, 10);
            Rover rover = new Rover(grid);

            String finalState = rover.execute("MMMRMMRMRMMMMMR");

            Assertions.assertThat(finalState).isEqualTo("O:9:2:W");
        }
    }

    @Test
    void should_stay_at_initial_state_given_an_empty_command() {
        Grid grid = new Grid(10, 10);
        Rover rover = new Rover(grid);

        String finalState = rover.execute("");

        Assertions.assertThat(finalState).isEqualTo("0:0:N");
    }
}