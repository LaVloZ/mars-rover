package lv.merrill.mars_rover;

public class Rover {
    public Rover(Grid grid) {
    }

    public Rover() {
    }

    public String execute(String command) {
        if (validate(command)) {
            return "0:0:" + "N";
        }
        String n = "N";
        for (int i = 0; i < command.length(); i++) {
            String charInt = String.valueOf(command.charAt(i));
            if ("R".equals(charInt)) {
                n = rightOf(n);
            }
        }
        return "0:0:" + n;
    }

    private String rightOf(String direction) {
        if ("N".equals(direction)) {
            return "E";
        }
        if ("E".equals(direction)) {
            return "S";
        }
        if ("S".equals(direction)) {
            return "W";
        }
        if ("W".equals(direction)) {
            return "N";
        }
        throw new RuntimeException("Not yet implemented");
    }

    private boolean validate(String command) {
        return command == null || command.isEmpty();
    }
}
