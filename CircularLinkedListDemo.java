public class CircularLinkedListDemo {
    public static void main(String[] args) {
        // CircularLinkedList cLL = new CircularLinkedList();
        // cLL.add(10);
        // cLL.add(20);
        // cLL.add(30);
        // cLL.add(40);
        // cLL.delete(30);
        // cLL.printList();
        DoublyCircularLinkedList dCLL = new DoublyCircularLinkedList();
        dCLL.add(10);
        dCLL.add(20);
        dCLL.add(30);
        dCLL.add(40);
        dCLL.delete(30);
        dCLL.addToFirst(0);
        dCLL.printList();
    }
}

class CircularLinkedList {
    Node head;

    public void add(int data) {
        Node nN = new Node(data);
        if (head == null) {
            head = nN;
            nN.next = nN;
        } else {
            Node current = head;
            while (current.next != head)
                current = current.next;
            nN.next = current.next;
            current.next = nN;
        }
    }

    public void delete(int data) {
        Node current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }

    }

    public void printList() {
        Node current = head;
        do {
            System.out.print(current.data + (current.next == head ? "" : " -> "));
            current = current.next;
        } while (current != head);

    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}

class DoublyCircularLinkedList {
    DoublyNode head;

    public void addToFirst(int data) {
        DoublyNode nN = new DoublyNode(data);
        if (head == null) {
            head = nN;
            nN.next = nN;
            nN.previous = nN;
        } else {
            nN.next = head;
            nN.previous = head.previous;
            head.previous = nN;
            head = nN;
        }
    }

    public void add(int data) {
        DoublyNode nN = new DoublyNode(data);
        if (head == null) {
            head = nN;
            nN.next = nN;
            nN.previous = nN;
        } else {
            DoublyNode current = head;
            while (current.next != head)
                current = current.next;
            nN.next = current.next;
            nN.previous = current;
            current.next = nN;
            head.previous = nN;
        }
    }

    public void delete(int data) {
        DoublyNode current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                DoublyNode next = current.next;
                current.next = next.next;
                next.next.previous = current;
                next.next = null;
                next.previous = null;
                break;
            }
            current = current.next;
        }
    }

    public void printList() {
        DoublyNode current = head;
        System.out.print(current.data);
        do {
            System.out.print(current.data + (current.next == head ? "" : " -> "));
            current = current.next;
        } while (current != head);
        // System.out.print("\n");
        // do {
        // current = current.previous;
        // System.out.print(current.data + (current == head ? "" : " -> "));
        // } while (current != head);

    }
}

class DoublyNode {
    DoublyNode previous;
    DoublyNode next;
    int data;

    DoublyNode(int data) {
        this.data = data;
    }
}