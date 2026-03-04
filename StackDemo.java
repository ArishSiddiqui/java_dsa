import java.util.Arrays;

public class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.peek();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.printSize();
        s.push(50);
        s.push(60);
        s.push(70);
        s.push(80);
        s.push(90);
        s.printSize();
        s.pop();
        s.pop();
        s.printSize();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.printStack();
        s.pop();
        s.pop();
        s.printSize();
        s.peek();
    }
}

// Created a growable Stack (Dynamic Stack)

class Stack {
    int top = -1;
    int[] stack;

    Stack() {
        stack = new int[8];
    }

    public void push(int data) {
        stack[top + 1] = data;
        if (top == (stack.length - 2)) {
            int newSize = stack.length * 2;
            stack = Arrays.copyOf(stack, newSize);
        }
        top++;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            if (top == ((stack.length / 2) - 1)) {
                int newSize = stack.length / 2;
                stack = Arrays.copyOf(stack, newSize);
            }
            top--;
        }
    }

    public void peek() {
        if (top != -1) {
            System.out.println(stack[top]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    public void printSize() {
        System.out.println("Size : " + stack.length);
    }

    public void printStack() {
        int i = 0;
        while (i <= top) {
            System.out.println(stack[i]);
            i++;
        }
    }
}
