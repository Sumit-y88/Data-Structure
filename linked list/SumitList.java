import java.util.Scanner;

public class SumitList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return;
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        return;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data + "deleted");
            head = null;
            return;
        }
        Node s = head;
        Node f = head.next;
        while (f.next != null) {
            s = s.next;
            f = f.next;
        }
        System.out.println(f.data + " deleted ");
        s.next = null;
        return;
    }

    public void deleteAt(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos <= 0) {
            System.out.println("Enter a valid position (starting from 1)");
            return;
        }

        // Deleting the first node
        if (pos == 1) {
            System.out.println(head.data + " deleted");
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }

        // temp is now (pos-1)th node
        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }

        System.out.println(temp.next.data + " deleted");
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumitList list = new SumitList();

        int choice;
        do {
            System.out.println("\n==== Linked List Menu ====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Delete at Position");
            System.out.println("6. Display List");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int val1 = sc.nextInt();
                    list.addFirst(val1);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int val2 = sc.nextInt();
                    list.addLast(val2);
                    break;
                case 3:
                    list.deleteFirst();
                    break;
                case 4:
                    list.deleteLast();
                    break;
                case 5:
                    System.out.print("Enter position to delete: ");
                    int pos = sc.nextInt();
                    list.deleteAt(pos);
                    break;
                case 6:
                    list.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}