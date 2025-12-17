import java.util.Scanner;

public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // Insert a node in BST
    public Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Inorder traversal (sorted order)
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Search a node
    public boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        else if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Delete a node
    public Node delete(Node root, int key) {
        if (root == null)
            return null;
        
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: no child
            if (root.left == null && root.right == null)
                return null;
            // Case 2: one child
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // Case 3: two children
            else {
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    // Find inorder successor (smallest in right subtree)
    public Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Menu-driven main
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, val;

        do {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert Node");
            System.out.println("2. Display Inorder");
            System.out.println("3. Search Node");
            System.out.println("4. Delete Node");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    val = sc.nextInt();
                    tree.root = tree.insert(tree.root, val);
                    System.out.println("Node inserted successfully!");
                    break;
                case 2:
                    System.out.print("Inorder Traversal: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    val = sc.nextInt();
                    if (tree.search(tree.root, val))
                        System.out.println("Node found in BST!");
                    else
                        System.out.println("Node not found!");
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    val = sc.nextInt();
                    tree.root = tree.delete(tree.root, val);
                    System.out.println("Node deleted (if present).");
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}