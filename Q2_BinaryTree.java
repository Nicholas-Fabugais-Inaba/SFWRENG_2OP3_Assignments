/* Assignment 8 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (60 marks)
    Use Java to implement a binary tree and implement the following classes and methods.
    * 1. Design the class for the binary tree
    * 2. addChild: adds a child to a node if the node does not have two children already.
    * 3. deleteChild: delete a child from a node if the child is a leaf node.
    * 4. In the main() method, use your code to build a tree A in the following example.
    * 5. Delete the node with key=20 in tree A, to get the Tree B in the following example.

* Example:
           50                            50
        /     \         delete(20)      /   \
      30      70       --------->    30     70
     /  \    /  \                     \    /  \
   20   40  60   80                   40  60   80
         (tree A)                       (Tree B)

 */

// Class containing left and right child of current node and key value
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// A Java program to introduce Binary Tree
class Q2_BinaryTree {
    // Root of Binary Tree
    Node root; // The root node of the binary tree.

    // Design the constructor of the class 'Q2_BinaryTree'
    // (5 marks)
    Q2_BinaryTree (int item) {
        root = new Node(item);
    }

    // addChild() adds 'child_node' as a child of the 'parent_node'.
    // if 'is_left' is true, then add the 'child_node' as a left child of the 'parent node'
    // if 'is_left' is false, then add the 'child_node' as a right child of the 'parent node'
    // if the target position of the child is already taken, then we should stop adding.
    // (20 marks)
    public void addChild(Node parent_node, Node child_node, boolean is_left){

        if (is_left == true) {
            if (parent_node.left != null) {
                addChild(parent_node.left, child_node, true);
            } else {
                parent_node.left = child_node;
            }
        } else {
            if (parent_node.right != null) {
                addChild(parent_node.right, child_node, false);
            } else {
                parent_node.right = child_node;
            }
        }

    }

    // deleteChild() deletes a child of teh 'parent_node'.
    // if 'is_left' is true, then delete the left child of the 'parent_node'
    // if 'is_left' is false, then delete the right child of the 'parent_node'
    // if the target child to delete is null, then the deletion should stop.
    // (20 marks)
    public void deleteChild(Node parent_node, boolean is_left) {

        if (is_left == true) {
            if (parent_node.left != null) {
                parent_node.left = null;
            }
        } else {
            if (parent_node.right != null) {
                parent_node.right = null;
            }
        }
    }

    // This method is for TA's use.
    public void printTree() {
        String prefix = "";
        printTreeCore(prefix, this.root, false);
    }

    // This method is for TA's use.
    private void printTreeCore(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "L-- " : "R-- ") + n.key);
            printTreeCore(prefix + (isLeft ? "|   " : "    "), n.right, false);
            printTreeCore(prefix + (isLeft ? "|   " : "    "), n.left, true);
        }
    }

    public static void main(String[] args) {
        Q2_BinaryTree aTree = new Q2_BinaryTree(50);
        Node num1 = new Node(30);
        Node num2 = new Node(70);
        Node num3 = new Node(20);
        Node num4 = new Node(40);
        Node num5 = new Node(60);
        Node num6 = new Node(80);
        aTree.addChild(aTree.root, num1, true);
        aTree.addChild(aTree.root, num2, false);
        aTree.addChild(aTree.root.left, num3, true);
        aTree.addChild(aTree.root.left, num4, false);
        aTree.addChild(aTree.root.right, num5, true);
        aTree.addChild(aTree.root.right, num6, false);
        aTree.printTree();

        aTree.deleteChild(aTree.root.left, true);
        aTree.printTree();
    }
}