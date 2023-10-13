public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Node class to represent elements in the doubly linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    // Method to check if the doubly linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Method to get the size of the doubly linked list
    public int size() {
        return size;
    }
    
    // Method to add an element to the end of the doubly linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    // Method to remove an element from the doubly linked list
    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }
    
    // Method to display the doubly linked list in forward direction
    public void display() {
    Node<T> current = head;
    System.out.print("null <- ");
    while (current != null) {
        System.out.print(current.data);
        if (current.next != null) {
            System.out.print(" <-> ");
        } else {
            System.out.print(" -> null\n");
        }
        current = current.next;
    }
}
    
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println("Doubly Linked List (Forward): ");
        list.display();
        
        list.remove(3);
        list.remove(1);
        
        System.out.println("After removing elements: ");
        list.display();
    }
}
