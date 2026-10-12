package structures;

import java.util.Stack;

public class ActionStack {
    private Stack<String> actions = new Stack<>();

    public void pushAction(String actionDescription) {
        actions.push(actionDescription);
        System.out.println("Action added: " + actionDescription);
    }

    public void popAction() {
        if (actions.isEmpty()) {
            System.out.println("Stack is empty. Nothing to remove.");
            return;
        }
        System.out.println("Removed: " + actions.pop());
    }

    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("\n--- Recent Actions (most recent first) ---");
        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println(actions.get(i));
        }
    }

    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
