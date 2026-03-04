import java.util.Arrays;

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(20);
        q.add(30);
        q.add(40);
        q.addFront(10);
        q.getFirstElement();
        q.getLastElement();
        // q.deleteRear();
        // q.getLastElement();
        // q.deleteRear();
        // q.getLastElement();
        // q.deleteRear();
        // q.getFirstElement();
        // q.getLastElement();
        // q.deleteRear();
    }
}

class Queue {
    int front = 0;
    int rear = -1;

    int[] queue;

    Queue() {
        queue = new int[4];
    }

    public void add(int data) {
        queue[rear + 1] = data;
        if (rear == (queue.length - 1)) {
            int newSize = queue.length * 2;
            queue = Arrays.copyOf(queue, newSize);
        }
        rear++;
    }

    public void addFront(int data) {
        if (rear == (queue.length - 1)) {
            int newSize = queue.length * 2;
            queue = Arrays.copyOf(queue, newSize);
        }
        for (int i = rear; i >= front; i--) {
            queue[i + 1] = queue[i];
        }
        queue[front] = data;
        rear++;
    }

    public void deleteFront() {
        if (rear < 0) {
            System.out.println("Stack is Empty");
            return;
        }
        front++;
        if (front > rear) {
            front = 0;
            rear = -1;
        }
    }

    public void deleteRear() {
        if (rear < 0) {
            System.out.println("Stack is Empty");
            return;
        }
        rear--;
        if (rear < front) {
            front = 0;
            rear = -1;
        }
    }

    public void getFirstElement() {
        if (rear < 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println(String.format("Element at %d: %d", front, queue[front]));
        }
    }

    public void getLastElement() {
        if (rear < 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println(String.format("Element at %d: %d", rear, queue[rear]));
        }
    }
}
