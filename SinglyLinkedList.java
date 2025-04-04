class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    // Insertion
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Position must be > 0");
            return;
        }
        Node newNode = new Node(data);
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Deletion
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    public void deleteAtPosition(int pos) {
        if (pos <= 0) {
            System.out.println("Position must be > 0");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp.next != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    // Display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtBeginning(5);
        list.insertAtPosition(7, 2);
        list.display();             // 5 -> 7 -> 10 -> null
        list.deleteAtPosition(2);
        list.display();             // 5 -> 10 -> null
        list.deleteAtEnd();
        list.display();             // 5 -> null
    }
}
