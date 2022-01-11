/* Assignment 11 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (50 marks in total)
    Use mutils.BinarySearchTree as a basic structure to implement a TreeMap for <String, Integer>.
    You cannot use JCF provided map.
 */

import mutils.BinarySearchTree;
import mutils.Node;

import java.util.*;

public class Q1_TreeMapByBST {

    // use m_bst as the basic data structure for the treemap of <String, Integer>
    BinarySearchTree m_bst = new BinarySearchTree();

    // Question 1.1 (5 marks): implement method size().
    // Returns the number of elements in this map (its cardinality).
    // You can ONLY modify the body of this method including the return statement.
    public int size() {
        if (m_bst.root != null) {
            int size = 0;
            Queue<Node> nodeQueue = new LinkedList<>();

            nodeQueue.add(m_bst.root);
            while (!nodeQueue.isEmpty()) {
                Node node = nodeQueue.poll();
                size++;
                if(node.left!=null){
                    nodeQueue.add(node.left);
                }
                if(node.right!=null){
                    nodeQueue.add(node.right);
                }
            }
            return size;
        }
        return 0;
    }

    // Question 1.2 (5 marks): implement method isEmpty().
    // Returns true if this map contains no elements, otherwise return false.
    // You can ONLY modify the body of this method including the return statement.
    public boolean isEmpty() {
        if (m_bst.root == null) {
            return true;
        }
        return false;
    }

    // Question 1.3 (15 marks) implement method get().
    // If key is contained in the map, return the value of the key.
    // If key is not contained in the map, return -1.
    // You can ONLY modify the body of this method including the return statement.
    public int get(String key) {
        Stack<Node> nodes = new Stack<>();
        Node nodeCurrent = m_bst.root;
        while (!nodes.isEmpty() || nodeCurrent != null) {
            if (nodeCurrent != null) {
                if (nodeCurrent.data == key) {
                    return nodeCurrent.freq;
                }
                nodes.push(nodeCurrent);
                nodeCurrent = nodeCurrent.left;
            } else {
                Node node = nodes.pop();
                nodeCurrent = node.right;
            }
        }
        return -1;
    }

    // Question 1.4 (15 marks) implement method put().
    // If the key is already contained in the map, overwrite the old value and return -1;
    // If the key is not contained in the map, add a new <key,value> entry to the map and return 1;
    // You can ONLY modify the body of this method including the return statement.
    public int put(String key, int value) {
        Stack<Node> nodes = new Stack<>();
        Node nodeCurrent = m_bst.root;
        while (!nodes.isEmpty() || nodeCurrent != null) {
            if (nodeCurrent != null) {
                if (nodeCurrent.data == key) {
                    nodeCurrent.freq = value;
                    return -1;
                }
                nodes.push(nodeCurrent);
                nodeCurrent = nodeCurrent.left;
            } else {
                Node node = nodes.pop();
                nodeCurrent = node.right;
            }
        }
        m_bst.insert(new Node(key, value));
        return 1;
    }

    // Question 1.5 (10 marks) implement method getKeysInAlphabeticalOrder().
    // return the keys of this map as an ArrayList<String> in Alphabetical order.
    // You can ONLY modify the body of this method including the return statement.
    public ArrayList<String> getKeysInAlphabeticalOrder(){
        Stack<Node> nodes = new Stack<>();
        ArrayList<String> keys = new ArrayList<>();
        Node nodeCurrent = m_bst.root;
        while (!nodes.isEmpty() || nodeCurrent != null) {
            if (nodeCurrent != null) {
                nodes.push(nodeCurrent);
                keys.add(nodeCurrent.data);
                nodeCurrent = nodeCurrent.left;
            } else {
                Node node = nodes.pop();
                nodeCurrent = node.right;
            }
        }
        Collections.sort(keys);
        return keys;
    }
}
