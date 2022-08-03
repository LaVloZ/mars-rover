package lv.merrill.mars_rover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    @Nested
    class Acceptance {
        @Test
        void should_be_blocked_at_9_2_W() {
            Grid grid = new Grid(10, obstacle(at(8, 2)));
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

            @ParameterizedTest
            @CsvSource({
                    "R, 0:0:E",
                    "RR, 0:0:S",
                    "RRR, 0:0:W",
                    "RRRR, 0:0:N"
            })
            void should_turn_to_east_given_right_command(final String command, final String state) {
                Rover rover = new Rover();

                String finalState = rover.execute(command);

                assertThat(finalState).isEqualTo(state);
            }
        }

        @Nested
        class Left {
            @ParameterizedTest
            @CsvSource({
                    "L, 0:0:W",
                    "LL, 0:0:S",
                    "LLL, 0:0:E",
                    "LLLL, 0:0:N"
            })
            void should_turn_to_west_given_left_command(final String command, final String state) {
                Rover rover = new Rover();

                String finalState = rover.execute(command);

                assertThat(finalState).isEqualTo(state);
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

                @ParameterizedTest
                @CsvSource({
                        "LM, 9:0:W",
                        "MLM, 9:1:W",
                        "MMLM, 9:2:W",
                })
                void should_wrap_around_to_west(final String command, final String state) {
                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute(command);

                    assertThat(finalState).isEqualTo(state);
                }
            }

            @Nested
            class South {
                @ParameterizedTest
                @CsvSource({
                        "RRM, 0:9:S",
                        "RMRM, 1:9:S",
                        "RMMRM, 2:9:S",
                })
                void should_wrap_around_to_south(final String command, final String state) {

                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute(command);

                    assertThat(finalState).isEqualTo(state);
                }
            }

            @Nested
            class North {
                @ParameterizedTest
                @CsvSource({
                        "MMMMMMMMMM, 0:0:N",
                        "RMLMMMMMMMMMM, 1:0:N",
                        "RMMLMMMMMMMMMM, 2:0:N",
                })
                void should_wrap_around_to_north(final String command, final String state) {

                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute(command);

                    assertThat(finalState).isEqualTo(state);
                }
            }

            @Nested
            class East {
                @ParameterizedTest
                @CsvSource({
                        "RMMMMMMMMMM, 0:0:E",
                        "MRMMMMMMMMMM, 0:1:E",
                        "MMRMMMMMMMMMM, 0:2:E",
                })
                void should_wrap_around_to_east(final String command, final String state) {

                    Rover rover = new Rover(new Grid(10));

                    String finalState = rover.execute(command);

                    assertThat(finalState).isEqualTo(state);
                }
            }
        }

        @ParameterizedTest
        @CsvSource({
                "M, 0, 1, O:0:0:N",
                "MM, 0, 2, O:0:1:N",
                "MMM, 0, 3, O:0:2:N",
        })
        void should_stop_given_an_obstacle(String command, int x, int y, String state) {
            Grid grid = new Grid(10, obstacle(at(x, y)));
            Rover rover = new Rover(grid);

            String finalState = rover.execute(command);

            assertThat(finalState).isEqualTo(state);
        }
    }

    private static Coordinate at(final int x, final int y) {
        return new Coordinate(x, y);
    }

    private static HashSet<Coordinate> obstacle(Coordinate coordinate) {
        return new HashSet<>(asList(coordinate));
    }
}