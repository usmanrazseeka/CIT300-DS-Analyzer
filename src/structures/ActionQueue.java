
package structures;

import java.util.LinkedList;
import java.util.Queue;

public class ActionQueue {

    private Queue<String> actions = new LinkedList<>();

    // Add an action to the end of the queue
    public void enqueueAction(String actionDescription) {
        actions.offer(actionDescription);
        System.out.println("Action added to queue: " + actionDescription);
    }

    // Remove the oldest action from the queue
    public void dequeueAction() {
        if (actions.isEmpty()) {
            System.out.println("Queue is empty. Nothing to remove.");
            return;
        }

        System.out.println("Removed action: " + actions.poll());
    }

    // View the next action without removing it
    public void peekAction() {
        if (actions.isEmpty()) {
            System.out.println("Queue is empty. Nothing to view.");
            return;
        }

        System.out.println("Next action: " + actions.peek());
    }

    // Display all actions in the queue
    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No pending actions.");
            return;
        }

        System.out.println("\n--- Pending Actions (oldest first) ---");

        for (String action : actions) {
            System.out.println(action);
        }
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
