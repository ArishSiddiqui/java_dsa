class LinkedList {
    Node head;

    public void addAtFirst(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head.next;
            head.next = n;
        }
    }

    public void delete(int data) {
        if (head != null) {
            Node n = head;
            while (n.next != null) {
                if (n.next.data == data) {
                    Node next = n.next.next;
                    n.next.next = null;
                    n.next = next;
                    break;
                }
                n = n.next;
            }
        }
    }

    public void printList() {
        Node tN = head;
        while (tN != null) {
            System.out.print(tN.data + " -> ");
            tN = tN.next;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList lL = new LinkedList();
        lL.add(10);
        lL.add(20);
        lL.add(30);
        lL.addAtFirst(0);
        lL.delete(20);
        lL.printList();
    }
}