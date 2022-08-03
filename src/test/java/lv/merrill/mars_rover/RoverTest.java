package lv.merrill.mars_rover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    @Nested
    class Acceptance {
        @Test
        void should_be_blocked_at_9_2_W() {
            Grid grid = new Grid(10, 10);
            Rover rover = new Rover(grid);

            String finalState = rover.execute("MMMRMMRMRMMMMMR");

            assertThat(finalState).isEqualTo("O:9:2:W");
        }
    }

    @Nested
    class CommandInputProcessing {

        @Test
        void should_stay_at_initial_state_given_an_empty_command() {
            Rover rover = new Rover();

            String finalState = rover.execute("");

            assertThat(finalState).isEqualTo("0:0:N");
        }

        @Test
        void should_stay_at_initial_state_given_a_null_command() {
            Rover rover = new Rover();

            String finalState = rover.execute(null);

            assertThat(finalState).isEqualTo("0:0:N");
        }
    }

    @Test
    void should_turn_to_east_given_one_right_command() {
        Rover rover = new Rover();

        String finalState = rover.execute("R");

        assertThat(finalState).isEqualTo("0:0:E");
    }
}