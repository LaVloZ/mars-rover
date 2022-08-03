package lv.merrill.mars_rover;

public class Rover {
    public Rover(Grid grid) {
    }

    public String execute(String command) {
        if(command.isEmpty()) return "0:0:N";
        throw new RuntimeException("Not yet implemeted");
    }
}
