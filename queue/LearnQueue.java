import java.util.*;

class LearnQueue {
    public class InnerQueue {
        int[] queue;
        int front;
        int rear;
        int size;

        InnerQueue(int size) {
            this.size = size;
            this.front = -1;
            this.rear = -1;
            queue = new int[size];
        }

        public void enqueue(int val) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1)
                front = 0;
            queue[++rear] = val;
            System.out.println("Enqueued value: " + val);
        }

        public boolean isEmpty() {
            return front == -1 || front > rear;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("The Queue is empty");
                return -1;
            }
            int val = queue[front++];
            if (front > rear) {
                front = -1;
                rear = -1;
            }
            System.out.println("Dequeued value: " + val);
            return val;
        }

        public boolean isFull() {
            return rear == size - 1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("The Queue is empty");
                return;
            }
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LearnQueue outer = new LearnQueue();
        InnerQueue q = outer.new InnerQueue(5);
        int ops;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ops = sc.nextInt();

            switch (ops) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.out.println(q.isEmpty() ? "Queue is empty" : "Queue is not empty");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (ops != 5);

        sc.close();
    }
}
