package lineardatastructures.Arrays.Array;

public class Array<T> {
    private Node<T> head;
    private int size;

    public Array() {
        this.head = null;
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        return current.data;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        current.data = value;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> lastNode = getNode(size - 1);
            lastNode.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> prevNode = getNode(index - 1);
            Node<T> currentNode = prevNode.next;
            prevNode.next = currentNode.next;
        }
        size--;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);

        System.out.println("Size: " + arr.getSize());
        System.out.println("Element at index 2: " + arr.get(2));

        arr.set(2, 35);

        System.out.println("Element at index 3: " + arr.get(2));

        arr.remove(1);

        System.out.println("Size after removing element at index 1: " + arr.getSize());
    }
}