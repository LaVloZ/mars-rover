package lv.merrill.mars_rover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    @Nested
    class Acceptance {
        @Test
        void should_be_blocked_at_9_2_W() {
            Grid grid = new Grid(10);
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
    class Turn {
        @Nested
        class Right {

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

        @Nested
        class Left {
            @Test
            void should_turn_to_west_given_one_left_command() {
                Rover rover = new Rover();

                String finalState = rover.execute("L");

                assertThat(finalState).isEqualTo("0:0:W");
            }

            @Test
            void should_turn_to_south_given_two_left_commands() {
                Rover rover = new Rover();

                String finalState = rover.execute("LL");

                assertThat(finalState).isEqualTo("0:0:S");
            }

            @Test
            void should_turn_to_east_given_three_left_commands() {
                Rover rover = new Rover();

                String finalState = rover.execute("LLL");

                assertThat(finalState).isEqualTo("0:0:E");
            }

            @Test
            void should_turn_to_east_given_four_left_commands() {
                Rover rover = new Rover();

                String finalState = rover.execute("LLLL");

                assertThat(finalState).isEqualTo("0:0:N");
            }
        }
    }

    @Nested
    class Move {
        @Test
        void should_move_to_north_given_north_direction() {
            Rover rover = new Rover();

            String finalState = rover.execute("MMM");

            assertThat(finalState).isEqualTo("0:3:N");
        }

        @Test
        void should_move_to_east_given_east_direction() {
            Rover rover = new Rover();

            String finalState = rover.execute("RMMM");

            assertThat(finalState).isEqualTo("3:0:E");
        }

        @Test
        void should_move_to_south_given_south_direction() {
            Rover rover = new Rover();

            String finalState = rover.execute("MMMRRMM");

            assertThat(finalState).isEqualTo("0:1:S");
        }

        @Test
        void should_move_to_west_given_west_direction() {
            Rover rover = new Rover();

            String finalState = rover.execute("RMMMRRMM");

            assertThat(finalState).isEqualTo("1:0:W");
        }

        @Nested
        class WrapAround {

            @Nested
            class West {

                @Test
                void should_wrap_around_to_west() {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("LM");

                    assertThat(finalState).isEqualTo("9:0:W");
                }

                @Test
                void should_wrap_around_to_west1() {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("MLM");

                    assertThat(finalState).isEqualTo("9:1:W");
                }

                @Test
                void should_wrap_around_to_west2() {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("MMLM");

                    assertThat(finalState).isEqualTo("9:2:W");
                }
            }

            @Nested
            class South {
                @Test
                void should_wrap_around_to_south() {

                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("LLM");

                    assertThat(finalState).isEqualTo("0:9:S");
                }

                @Test
                void should_wrap_around_to_south2() {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("LMLM");

                    assertThat(finalState).isEqualTo("1:9:S");
                }

                @Test
                void should_wrap_around_to_south3() {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute("LMMLM");

                    assertThat(finalState).isEqualTo("2:9:S");
                }
            }
        }
    }
}