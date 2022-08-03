package lv.merrill.mars_rover;

public class Rover {
    public Rover(Grid grid) {
    }

    public Rover() {
    }

    public String execute(String command) {
        if (validate(command)) {
            return "0:0:N";
        }
        if ("R".equals(command)) {
            return "0:0:E";
        }
        throw new RuntimeException("Not yet implemeted");
    }

    private boolean validate(String command) {
        return command == null || command.isEmpty();
    }
}
