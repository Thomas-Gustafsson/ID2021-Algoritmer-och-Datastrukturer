package mytree;
import java.util.Random;

// Java program to demonstrate
// insert operation in binary
// search tree
class BinaryTree {

    /* Class containing left
       and right child of current node
     * and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinaryTree() { root = null; }

    BinaryTree(int value) { root = new Node(value); }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            // System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    boolean search(int key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }

    //recursive insert function
    Node search_Recursive(Node root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }

    // Driver Code
    public static void main(String[] args) {
        int benches = 10000;
        long t_total = 0;
        int counter = 10;

        for (int k = 0; k < benches; k++) {
            int times = 10, insertions = 10;

            for (int j = 0; j < times; j++) {
                Random rnd = new Random();
                int value = 10;
                BinaryTree tree = new BinaryTree();

                /* Let us create following BST
                      50
                   /     \
                  30      70
                 /  \    /  \
               20   40  60   80 */

                for (int i = 0; i < insertions; i++) {
                    tree.insert(rnd.nextInt(1,benches));
                    value += 1;
                }

                // print inorder traversal of the BST
                tree.inorder();

                long t0 = System.nanoTime();
                //search a key in the BST
                boolean ret_val = tree.search(value);
                // System.out.println("\nKey 50 found in BST:" + ret_val);
                t_total += (System.nanoTime() - t0);

                insertions++;
            }
            System.out.println(counter + " " + t_total);
            counter++;
        }
    }
}
