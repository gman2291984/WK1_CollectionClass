package library;

public class IntNode {
    private int sequenceNumber; // TCP sequence number for ordering packets
    private int data; // Payload data of the packet
    private IntNode link; // Pointer to the next node in the linked list

    // Constructor: Initializes a new node with sequenceNumber, data, and a link to the next node
    // Precondition: None
    // Postcondition: All instance variables of the IntNode class are initialized.
    public IntNode(int initialSequenceNumber, IntNode initialLink, int initialData) {
        this.sequenceNumber = initialSequenceNumber; // Set sequence number
        this.link = initialLink; // Link this node to the next node in the list
        this.data = initialData; // Store packet data
    }

    // Adds a new node immediately after the current node, maintaining linked list order.
    // Precondition: The current node exists in the list.
    // Postcondition: A new node with attributes (sequenceNumber, data) is added right after this node.
    public void addNodeAfter(int data, int item) {
        this.link = new IntNode(item, this.link, data); // Insert a new node after the current node
    }

    // Removes the node that comes immediately after the current node.
    // Precondition: The current node exists in the list.
    // Postcondition: The node right after this node is removed from the list.
    public void removeNodeAfter() {
        if (this.link != null) { // If there is a next node, remove it
            this.link = this.link.link; // Skip the next node, effectively removing it
        }
    }

    // Returns the sequence number of this node and resets the detection flag (not used here).
    // Precondition: The node exists.
    // Postcondition: The sequence number is returned.
    public int getsequenceNumber(boolean detectionFlag) {
        detectionFlag = false; // Reset detection flag (not required in our implementation)
        return this.sequenceNumber; // Return sequence number of the current node
    }

    // Returns the next node in the linked list.
    // Precondition: This node exists.
    // Postcondition: The reference to the next node is returned.
    public IntNode getLink() {
        return this.link; // Return the next node reference
    }

    // Displays all nodes in the linked list starting from the head.
    // Precondition: The linked list contains at least one element.
    // Postcondition: The sequence numbers and data of all nodes are printed.
    public void displayNodeData(IntNode head) {
        System.out.print("The (sequence number, data) pairs in the linked list are: ");
        IntNode current = head; // Start from the head of the linked list

        while (current != null) { // Loop through each node in the list
            System.out.print("(" + current.sequenceNumber + "," + current.data + ") ");
            current = current.link; // Move to the next node
        }
        System.out.println("\n"); // Print new line at the end
    }

    // Finds the node that comes immediately before the node with the specified sequence number.
    // Precondition: The linked list contains at least one element.
    // Postcondition: The previous node (before target) is returned, or null if target is not found.
    public IntNode findPrevious(IntNode head, int target) {
        IntNode current = head; // Start from the head of the list

        while (current.link != null) { // Loop through the list until reaching the last node
            if (current.link.sequenceNumber == target) { // If the next node has the target sequence number
                return current; // Return the current node as it is the predecessor
            }
            current = current.link; // Move to the next node
        }
        return null; // If no node with the target sequence number is found, return null
    }

    // Finds the correct location for inserting a new node while maintaining ascending order.
    // Precondition: The linked list contains at least one element.
    // Postcondition: The node before the correct insertion position is returned.
    public IntNode locatePredecessor(IntNode head, int target) {
        IntNode current = head; // Start from the head of the list

        while (current.link != null && current.link.sequenceNumber < target) { // Traverse while the next node has a lower sequence number
            current = current.link; // Move to the next node
        }
        return current; // Return the node before where the new node should be inserted
    }
}
