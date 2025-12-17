import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    public static class SinglyLinkedList {
        Node head;

        SinglyLinkedList() {
            head = null;
        }

        Scanner sc = new Scanner(System.in);

        public void createList() {
            System.out.println("Enter the number of data you want to create:");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("List size must be positive.");
                return;
            }

            System.out.println("Enter data for linked list:");
            head = new Node(sc.nextInt());
            Node temp = head;

            for (int i = 1; i < n; i++) {
                Node m = new Node(sc.nextInt());
                temp.next = m;
                temp = m;
            }
        }

        public void insertBeg(int d) {
            Node m = new Node(d);
            m.next = head;
            head = m;
        }

        public void insertBack(int d) {
            Node m = new Node(d);
            if (head == null) {
                head = m;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = m;
        }

        public void traverseLL(int position) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (position <= 0) {
                System.out.println("Invalid position. Position must be >= 1.");
                return;
            }

            Node temp = head;
            for (int i = 1; i < position; i++) {
                if (temp.next == null) {
                    System.out.println("Location exceeds list length.");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Data at position " + position + " is: " + temp.data);
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1: Create List");
            System.out.println("2: Insert at Beginning");
            System.out.println("3: Insert at Back");
            System.out.println("4: Traverse");
            System.out.println("5: Print List");
            System.out.println("6: Exit");
            System.out.print("Choose an option: ");

            int ops = sc.nextInt();
            switch (ops) {
                case 1:
                    list.createList();
                    break;
                case 2:
                    System.out.print("Enter data to insert at beginning: ");
                    int dataBeg = sc.nextInt();
                    list.insertBeg(dataBeg);
                    break;
                case 3:
                    System.out.print("Enter data to insert at back: ");
                    int dataBack = sc.nextInt();
                    list.insertBack(dataBack);
                    break;
                case 4:
                    System.out.print("Enter location to traverse to: ");
                    int loc = sc.nextInt();
                    list.traverseLL(loc);
                    break;
                case 5:
                    list.printList();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Enter a valid option.");
            }
        }
    }
}
