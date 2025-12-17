public class DoublyLL {
    Node head;
    private int size;

    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            next = null;
            prev = null;
            size++;
        } 
    }

    // Add at first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at last
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
        newNode.prev = temp;
    }

    // Add in middle (at position 'loc', 0-based index)
    public void addInMiddle(String data, int loc) {
        if (loc < 0 || loc > size) {
            System.out.println("Invalid position!");
            return;
        }
        if (loc == 0) {
            addFirst(data);
            return;
        }
        if (loc == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < loc - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete by value
    public void delete(String data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;

        // If head is to be deleted
        if (temp.data.equals(data)) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return;
        }

        // Search for the node
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }

        // If not found
        if (temp == null) {
            System.out.println("Element not found!");
            return;
        }

        // Delete the node
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        size--;
    }

    // Print list forward
    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    // Get size
    public int getSize() {
        return size;
    }

    // Main function to test
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst("A");
        dll.addLast("B");
        dll.addLast("C");
        dll.addInMiddle("X", 1);
        dll.printList(); // A <-> X <-> B <-> C <-> null
        dll.delete("X");
        dll.printList(); // A <-> B <-> C <-> null
        System.out.println("Size: " + dll.getSize());
    }
}
