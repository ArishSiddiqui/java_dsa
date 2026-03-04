class DoublyLinkedList {
    Node head;

    public void addAtFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            head.previous = n;
            n.next = head;
            head = n;
        }
    }

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head.next;
            head.next = n;
            n.previous = head;
        }
    }

    public void delete(int data) {
        if (head != null) {
            Node n = head;
            Node previous = null;
            while (n != null) {
                if (n.data == data) {
                    if (previous != null) {
                        previous.next = n.next;
                        n.previous = previous;
                    } else {
                        head = n.next;
                    }
                    break;
                }
                previous = n;
                n = n.next;
            }
        }
    }

    public void printList() {
        Node tN = head;
        while (tN != null) {
            System.out.print(tN.data + ((tN.next == null) ? "" : " -> "));
            tN = tN.next;
        }
    }
}

class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {

        DoublyLinkedList dLL = new DoublyLinkedList();
        // dLL.add(10);
        // dLL.add(20);
        // dLL.add(30);
        dLL.addAtFirst(30);
        dLL.addAtFirst(20);
        dLL.addAtFirst(10);
        dLL.add(15);
        dLL.addAtFirst(5);
        dLL.delete(5);
        dLL.delete(15);
        dLL.printList();
    }
}