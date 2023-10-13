public class CircularLinkedList<T> {
    private Node<T> head;
    private int size;

    // Constructor to initialize an empty circular linked list
    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    // Node class to represent elements in the circular linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to check if the circular linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the circular linked list
    public int size() {
        return size;
    }

    // Method to add an element to the end of the circular linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head; // Circular reference to itself
        } else {
            newNode.next = head;
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to remove an element from the circular linked list
    public void remove(T data) {
        if (isEmpty()) {
            return;
        }

        if (head.data.equals(data)) {
            if (size == 1) {
                head = null;
            } else {
                Node<T> current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            size--;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        do {
            previous = current;
            current = current.next;
            if (current.data.equals(data)) {
                previous.next = current.next;
                size--;
                return;
            }
        } while (current != head);
    }

    // Method to display the circular linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Circular Linked List: ");
        list.display();

        list.remove(3);
        list.remove(1);

        System.out.println("After removing elements: ");
        list.display();
    }
}
