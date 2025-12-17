public class testLL {

    Node head;
    private int size;

    testLL() {
        size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add at the beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at the end
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }

        size--;
        head = head.next;
    }

    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }

        size--;

        if (head.next == null) { // only one node
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public int Size() {
        return size;
    }

    // Main
    public static void main(String[] args) {
        testLL list = new testLL();

        list.addFirst("Sumit");
        list.addFirst("is");
        list.addFirst("best");

        list.display();  // best -> is -> Sumit
        System.out.println("Size: " + list.Size());

        list.deleteFirst();
        list.display();  // is -> Sumit

        list.deleteLast();
        list.display();  // is

        System.out.println("Size: " + list.Size());
    }
}
