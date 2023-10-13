// Singly Linked List
public class LinkedList<T> {
    private Node<T> head;
    
    // Constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
    }
    
    // Node class to represent elements in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Method to get the size of the linked list
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Method to add an element to the end of the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Method to remove an element from the linked list
    public void remove(T data) {
        if (head == null) {
            return;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }
        
        if (current != null) {
            previous.next = current.next;
        }
    }
    
    // Method to display the linked list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println("Linked List: ");
        list.display();
        
        list.remove(3);
        list.remove(1);
        
        System.out.println("After removing elements: ");
        list.display();
    }
}
