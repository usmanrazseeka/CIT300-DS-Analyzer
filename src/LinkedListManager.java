import java.util.LinkedList;

public class LinkedListManager {
    private LinkedList<String> list = new LinkedList<>();

    // Add element
    public void addElement(String element) {
        list.add(element);
        System.out.println(element + " added");
    }

    // Display all
    public void displayList() {
        System.out.println("Linked List: " + list);
    }

    // Delete element
    public void removeElement(String element) {
        if (list.remove(element)) {
            System.out.println(element + " removed");
        } else {
            System.out.println(element + " not found");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedListManager manager = new LinkedListManager();
        manager.addElement("Afra");
        manager.addElement("CIT300");
        manager.addElement("Project");
        manager.displayList();
        manager.removeElement("CIT300");
        manager.displayList();
    }
}