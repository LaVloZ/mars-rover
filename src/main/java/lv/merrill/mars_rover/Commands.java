package lv.merrill.mars_rover;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Commands implements Command {

    private static final Map<String, Command> ALL_KNOWN_COMMANDS = new HashMap<>();

    static {
        ALL_KNOWN_COMMANDS.put("R", new RightCommand());
        ALL_KNOWN_COMMANDS.put("L", new LeftCommand());
        ALL_KNOWN_COMMANDS.put("M", new MoveCommand());
    }

    private final List<Command> commands;

    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public State execute(final State state) {
        State manipulatedState = state;
        for (Command command : commands) {
            manipulatedState = command.execute(manipulatedState);
        }
        return manipulatedState;
    }

    public static Command of(final String command) {
        if (isInvalid(command)) {
            return new DoNothingCommand();
        }

        String manipulatedCommand = command.toUpperCase();
        List<Command> knownCommands = manipulatedCommand.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(ALL_KNOWN_COMMANDS::get)
                .collect(Collectors.toList());

        return new Commands(knownCommands);
    }

    public static boolean isInvalid(String command) {
        return command == null || command.isEmpty();
    }
}
