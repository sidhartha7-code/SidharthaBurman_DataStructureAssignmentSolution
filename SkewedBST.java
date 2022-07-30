import java.util.ArrayList;
import java.util.Iterator;

public class SkewedBST {

    public static Node node;
    public static Node root;

    ArrayList<Node> nodes = new ArrayList<Node>();

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /* Create the BST as instructed in the problem statement*/
    public void createBST() {

        node = new Node(50); // Node is the root
        node.left = new Node(30);
        node.right = new Node(60);
        node.left.left = new Node(10);
        node.right.left = new Node(55);

        root = node;

    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void InOrder(Node root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        nodes.add(root);
        InOrder(root.right);
    }

    public void SkewTreeTraversal(Node r) {
        while (r != null) {
            System.out.print(r.data + " ");
            r = r.right;
        }
    }

    public void ArrayListTraversal() {
        Iterator<Node> itr = nodes.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().data + " ");
        }
    }

    public Node rightSkewedTree() {
        Node data;
        Node newRoot = nodes.get(0);
        Node ptr = newRoot;


        for (int i = 1; i < nodes.size(); i++) {
            ptr.left = null;
            ptr.right = nodes.get(i);
            ptr = ptr.right;
        }

        return newRoot;
    }

    public static void main(String[] args) {
        SkewedBST tree = new SkewedBST();
        /* Create Hardcoded Binary Search Tree */
        System.out.println("1. Creating Binary Search Tree");
        tree.createBST();

        /* Pre-Order Traversal of existing BST */
        System.out.println("2. Pre-Order Traversal of existing BST");
        tree.preOrder(root);
        System.out.println(" ");

        /* In-Order Traversal of existing BST */
        System.out.println("3. In-Order Traversal of existing BST");
        tree.InOrder(root);
        System.out.println(" ");

        /* Adding the Nodes in an ArrayList */
        System.out.println("4. Adding the Nodes and traversing the ArrayList");
        tree.ArrayListTraversal();
        System.out.println(" ");

        /* Method called to skew the existing BST */
        System.out.println("5. Skew the existing BST ");
        Node skewedRoot = tree.rightSkewedTree();

        /* Traversal of new BST */
        System.out.println("6. Traversal of new BST");
        tree.SkewTreeTraversal(skewedRoot);
    }
}
