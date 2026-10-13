import java.util.LinkedList;

public class LinkedListManager {
    LinkedList<String> list = new LinkedList<>();

    public void addElement(String element) {
        list.add(element);
        System.out.println(element + " added");
    }

    public void displayList() {
        System.out.println("Linked List: " + list);
    }

    public void removeElement(String element) {
        list.remove(element);
        System.out.println(element + " removed");
    }

    public void searchElement(String element) {
        int steps = 0;
        for (int i = 0; i < list.size(); i++) {
            steps++;
            if (list.get(i).equals(element)) {
                System.out.println("Found at position " + i);
                System.out.println("Steps checked: " + steps);
                return;
            }
        }
        System.out.println(element + " not found");
        System.out.println("Steps checked: " + steps);
    }

    public static void main(String[] args) {
        LinkedListManager manager = new LinkedListManager();
        manager.addElement("Afra");
        manager.addElement("CIT300");
        manager.addElement("Project");
        manager.displayList();
        manager.removeElement("CIT300");
        manager.displayList();
        manager.searchElement("Afra");
        manager.searchElement("Test");
    }
}