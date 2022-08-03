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

    @Nested
    class TurnRight {

        @Test
        void should_turn_to_east_given_one_right_command() {
            Rover rover = new Rover();

            String finalState = rover.execute("R");

            assertThat(finalState).isEqualTo("0:0:E");
        }

        @Test
        void should_turn_to_south_given_two_right_commands() {
            Rover rover = new Rover();

            String finalState = rover.execute("RR");

            assertThat(finalState).isEqualTo("0:0:S");
        }

        @Test
        void should_turn_to_west_given_three_right_commands() {
            Rover rover = new Rover();

            String finalState = rover.execute("RRR");

            assertThat(finalState).isEqualTo("0:0:W");
        }

        @Test
        void should_turn_to_north_given_four_right_commands() {
            Rover rover = new Rover();

            String finalState = rover.execute("RRRR");

            assertThat(finalState).isEqualTo("0:0:N");
        }
    }
}