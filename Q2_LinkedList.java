/* Assignment 7 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (60 marks)
    Use java to implement a data structure named LinkedList, and implement several methods of the LinkedList.

 */

class Node {
    int data; // 'data' stores the value of a node.
    Node next; // 'next' refers/points to the next node

    // the construction method of class Node.
    Node(int d) {
        data = d;
        next = null;
    }
}

class Q2_LinkedList {
    Node head;

    // Insert 'new_data' at the beginning of the LinkedList
    // (5 marks)
    public void insertAtBeginning(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
        } else {
            Node temp_node = head;
            head = new_node;
            head.next = temp_node;
        }
    }

    // Insert 'new_data' at the end of the LinkedList
    // (5 marks)
    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
        } else {
            Node temp_node = head;
            while(temp_node.next != null) {
                temp_node = temp_node.next;
            }
            temp_node.next = new_node;
        }
    }

    // Insert 'new_data' after a node referred to as 'prev_node'
    // (10 marks)
    public void insertAfter(Node prev_node, int new_data) {
        Node new_node = new Node(new_data);

        if (prev_node == null) {
            System.out.println("Invalid node given");
        } else {
            new_node.next = prev_node.next;
            prev_node.next = new_node;
        }
    }

    // Delete a node located in 'position' of the Linked List. The first element of the LinkedList has a position=0.
    // (10 marks)
    void deleteNode(int position) {

        Node node = head;

        int index = 0;
        while (index <= position) {
            if (node.next == null) {
                node = null;
            }
            if (index == position) {
                node.data = node.next.data;
                node.next = node.next.next;
            }
            node = node.next;
            index++;
        }

    }

    // Search for a node containing the value of 'key' in the LinkedList.
    // If there is a node in the LinkedList whose value is equal to 'key', then return 'true'.
    // If there is no node in the LinkedList whose value is equal to 'key', then return 'false'.
    // (15 marks)
    boolean search(Node head, int key) {
        while(head.next != null) {
            if (head.data == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // Sort the nodes in the LinkedList in ascending orders of their values.
    // Requirement: please use bubble sort.
    // Example: for a LinkedList: head->3->5->1->4->2, the sorted LinkedList should be head->1->2->3->4->5.
    // (15 marks)
    void sortLinkedList(Node head) {
        while (head != null) {
            Node position = head.next;
            while (position != null) {
                if (head.data > position.data) {
                    int temp_val = head.data;
                    head.data = position.data;
                    position.data = temp_val;
                }
                position = position.next;
            }
            head = head.next;
        }
    }

    // Print the linked list
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        /* TA may test different functions of the LinkedList here */
        /* The following is just an example of how to do the test. */

        Q2_LinkedList llist = new Q2_LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }
}