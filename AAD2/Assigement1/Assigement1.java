import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    Node root;

    void buildTree(int[] T) {
        for (int val : T) {
            root = bstInsert(root, val);
        }
    }

    private Node bstInsert(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (data < node.data)
            node.left = bstInsert(node.left, data);
        else if (data > node.data)
            node.right = bstInsert(node.right, data);
        return node;
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    int nthPreOrder(Node node, int n) {
        return nthByOrder(node, n, "pre");
    }

    int nthPostOrder(Node node, int n) {
        return nthByOrder(node, n, "post");
    }

    int nthInOrder(Node node, int n) {
        return nthByOrder(node, n, "in");
    }

    private int nthByOrder(Node node, int n, String order) {
        List<Integer> result = new ArrayList<>();
        collect(node, result, order);
        if (n < 1 || n > result.size()) {
            System.out.println("Index out of bounds. Tree has " + result.size() + " nodes.");
            return -1;
        }
        return result.get(n - 1);
    }

    private void collect(Node node, List<Integer> list, String order) {
        if (node == null)
            return;

        if ("pre".equals(order))
            list.add(node.data);

        collect(node.left, list, order);

        if ("in".equals(order))
            list.add(node.data);

        collect(node.right, list, order);

        if ("post".equals(order))
            list.add(node.data);
    }

    void printTree(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Level " + level + ": ");

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
            level++;
        }
    }
}

public class Assigement1 {

    public static void main(String[] args) {

        int[] T = { 6, 4, 8, 2, 5, 7, 9, 1, 3, 10 };

        BinaryTree tree = new BinaryTree();

        System.out.println("===========================================");
        System.out.println("Q1: Binary Tree from T = [6,4,8,2,5,7,9,1,3,10]");
        System.out.println("===========================================");
        tree.buildTree(T);
        System.out.println("Tree Structure (Level-wise):");
        tree.printTree(tree.root);
        System.out.println();

        System.out.println("===========================================");
        System.out.println("Q2: Pre-Order Traversal (Root -> Left -> Right)");
        System.out.println("===========================================");
        System.out.print("Pre-Order: ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("===========================================");
        System.out.println("Q3: Post-Order Traversal (Left -> Right -> Root)");
        System.out.println("===========================================");
        System.out.print("Post-Order: ");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("===========================================");
        System.out.println("Q4: In-Order Traversal (Left -> Root -> Right)");
        System.out.println("===========================================");
        System.out.print("In-Order: ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("Q5: Nth Pre-Order Element");
        System.out.println("===========================================");
        System.out.print("Enter N for Pre-Order (1-indexed): ");
        int n5 = scanner.nextInt();
        int preResult = tree.nthPreOrder(tree.root, n5);
        if (preResult != -1)
            System.out.println("Node at position " + n5 + " in Pre-Order = " + preResult);
        System.out.println();

        System.out.println("===========================================");
        System.out.println("Q6: Nth Post-Order Element");
        System.out.println("===========================================");
        System.out.print("Enter N for Post-Order (1-indexed): ");
        int n6 = scanner.nextInt();
        int postResult = tree.nthPostOrder(tree.root, n6);
        if (postResult != -1)
            System.out.println("Node at position " + n6 + " in Post-Order = " + postResult);
        System.out.println();

        System.out.println("===========================================");
        System.out.println("Q7: Nth In-Order Element");
        System.out.println("===========================================");
        System.out.print("Enter N for In-Order (1-indexed): ");
        int n7 = scanner.nextInt();
        int inResult = tree.nthInOrder(tree.root, n7);
        if (inResult != -1)
            System.out.println("Node at position " + n7 + " in In-Order = " + inResult);
        System.out.println();

        scanner.close();
    }
}