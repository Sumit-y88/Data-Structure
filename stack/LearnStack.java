import java.util.*;

public class LearnStack {
    class Stack {
        int[] stack;
        int size;
        int top;

        Stack(int size) {
            this.size = size;
            stack = new int[size];
            this.top = -1;
        }

        // Push function
        public void push(int val) {
            if (top >= size - 1) {
                System.out.println("Stack Overflow");
            } else {
                stack[++top] = val;
                System.out.println(val + " pushed");
            }
        }

        // Peek function
        public void peek() {
            if (top == -1) {
                System.out.println("Stack Underflow");
            } else {
                System.out.println("Peek of the stack is: " + stack[top]);
            }
        }

        // Pop function
        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top--];
        }

        // IsEmpty function
        public boolean isEmpty() {
            return top == -1;
        }

        // Display function
        public void display() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        LearnStack outer = new LearnStack();
        Stack s = outer.new Stack(5);
        Scanner sc = new Scanner(System.in);
        int ops;
        do {
            System.out.println("\nSelect the operation to be performed on the stack:");
            System.out.println("1: Push operation");
            System.out.println("2: Pop operation");
            System.out.println("3: Peek operation");
            System.out.println("4: Display operation");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            ops = sc.nextInt();

            switch (ops) {
                case 1:
                    System.out.print("Enter the value you want to push: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;
                case 2:
                    int popped = s.pop();
                    if (popped != -1)
                        System.out.println("Popped value: " + popped);
                    break;
                case 3:
                    s.peek();
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (ops != 5);
    }
}
