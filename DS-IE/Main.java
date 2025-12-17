import java.util.Scanner;
 public class Main {

static class CircularQueue {
    int front, rear, size;
    String[] queue;

    CircularQueue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        queue = new String[size];
    }

    boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueueCall(String call) {
        if (isFull()) {
            System.out.println("Cannot take more calls, Full capacity reached");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = call;
        System.out.println("Call added: " + call);
    }

    void dequeueCall() {
        if (isEmpty()) {
            System.out.println("No call in Queue, work done!");
            return;
        }
        System.out.println("Serving call " + queue[front]);
        // condition for only one element in the queue
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("No ongoing calls");
            return;
        }
        System.out.print("Current Ongoing calls in Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + ", ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the employee: ");
        // int capacity = 5;
        int capacity = sc.nextInt();
        sc.nextLine();
        CircularQueue cq = new CircularQueue(capacity);

        while (true) {
            System.out.println("-----Welcome to Custom Call Center-----");
            System.out.println("1. Add Incoming Call");
            System.out.println("2. Serve Call");
            System.out.println("3. View Calls in Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the caller's name: ");
                    String caller = sc.nextLine();
                    cq.enqueueCall(caller);
                    break;
                case 2:
                    cq.dequeueCall();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    default:
                    System.out.println("Try Again,invalid input!");
            }
        }
    }
}
