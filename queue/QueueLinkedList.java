public class QueueLinkedList {

    // Node structure
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    // Enqueue
    public void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(x + " enqueued to queue");
    }

    // Dequeue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int val = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return val;
    }

    // Peek
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // MAIN
    public static void main(String[] args) {

        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front after dequeue: " + queue.peek());
    }
}
