import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RobotScheduler {
    private LinkedList<Robot> availableRobots;
    private ArrayList<Robot> chargingRobots;
    private ArrayList<Robot> workingRobots;

    /**
     * Default constructor
     */
    public RobotScheduler() {
        // Add 5 robots
        for (int i = 1; i <= 5; i++) {
            availableRobots.add(new Robot(i));
        }
    }

    /**
     * Takes an order, and assigns it to the robot that is first in line
     *
     * @param s The shelf to fetch
     * @return Returns whether or not the order was accepted. It will be rejected if there are no available robots
     */
    public boolean fetch(Shelf s) {
        Robot r;
        try {
            r = availableRobots.removeFirst();
        } catch (NoSuchElementException ex) {
            // No available robots to fetch the order
            return false;
        }

        workingRobots.add(r);

        // Give the robot directions
        // r.addDirections();

        return true;
    }

    /**
     * Will actually "move" the robots every "tick"
     */
    public void update() {
        for(Robot r: workingRobots) {
            r.move();
        }
    }

    // Need a way to detect if a robot has finished charging

    // Need a way to detect if a robot has reached its destination
}