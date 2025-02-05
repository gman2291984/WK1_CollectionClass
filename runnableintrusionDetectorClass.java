//define the package where the class belongs
package intrustionDetectorClass;

//Imports the IntNode class from the library package that we made
import library.IntNode;

//this defines the main class
public class runnableintrusionDetectorClass {

	//static = belongs to the class not the instance - shared amongst all instances.
	//static variable "head" is the first node of the linked list taht we'll be making/running
	static IntNode head = null;
	
	
	public static void main(String[] args) {
		
		System.out.println("Prj1 is running.\n");
		
		//we intialize the linked list with a single node.
		//sequenceNumber = 13, data = 230185386
		head = new IntNode(13, head, 230185386);
		
		//this dsiplays the node's data
	    head.displayNodeData(head);
		
	    //removing and adding nodes while preserving the order
	    //Tries to remove the node with the sequenceNumber 13
	    removeDuplicate(13);
		if (head != null)
	       head.displayNodeData(head);
		else
		{
		   System.out.print("The linked list is empty.\n");
		   System.out.print(" \n");
		}
		
		//add Node with the sequenceNumber 13, data 308329763
		//the same logic applies for the others
		addNodeInOder(13, 308329763);
	    head.displayNodeData(head);
	    
		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOder(14, 248041794);
	    head.displayNodeData(head);

		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOder(14, 295106305);
	    head.displayNodeData(head);
	    
		removeDuplicate(15); 
	    head.displayNodeData(head);
		addNodeInOder(15, 325615905);
	    head.displayNodeData(head);
	    
		removeDuplicate(16); 
	    head.displayNodeData(head);
		addNodeInOder(16, 652976466);
	    head.displayNodeData(head);
	    
		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOder(17, 847897267);
	    head.displayNodeData(head);

		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOder(17, 927847798);
	    head.displayNodeData(head);
	  
	    //printout a completion message
	    System.out.println("End of run.\n");
	    
	}
	
	
	// Precondition: head refers the first node in the linked list, or is null when the linked list is empty.
	// The linked list contains at least one element.
	// Postcondition: If the linked list contains a node with sequenceNumber equal to target, 
	// then that node is removed from the linked list. Otherwise, no changes are made.
	
	//This removes a node with the given sequenceNumber (target) from the linked list. 
	 //Return updates head of the linked list.
	public static IntNode removeDuplicate(int target)   
	{
	    if (head == null)
	    	//if the list is empty then return
	    	return head;
		
		System.out.println("Running removeDuplicate() on target " + target + "\n");
		
		IntNode previous = null;
		
		
		//if the target is a the head then update the head pointer
	    if (target == head.getsequenceNumber(true))
	    {
	    	head = head.getLink();
	    }	
	    else
	    	//locate the previous node before the target node
	        previous = head.findPrevious(head, target);
	    
	    //remove the target node if found
	    if (previous != null) 
	        previous.removeNodeAfter();
	    	    
	    return head;
	} 
	
	
	// Precondition: head refers the first node in the linked list, or is null when the linked list is empty.
	// Postcondition: A new node with attributes target and data is created. Target serves as sequenceNumber.
	// The new node is added to the linked list so that its sequenceNumber preserves the ascending order of the linked list
	// relative to the sequenceNumber.
	public static IntNode addNodeInOder(int target, int data)   
	{
        IntNode previous = null;
		
        System.out.println("Running addNodeInOrder() on target " + target + " and data " + data + "\n");
        
        //if the list is empty then create the first Node
        if (head == null)
        {
           head = new IntNode(target, head, data);	
           return head;	
        }
        
        //if the target should be the new head (the smallest sequenceNumber)
        if (target < head.getsequenceNumber(true))
        	head = new IntNode(target, head, data);
        else
        	//finds the predecessor node where the new node should be inserted
		    previous = head.locatePredecessor(head, target);
		
        //inserts the new node at the correct location
		if (previous != null)
		   previous.addNodeAfter(data, target);
		
		
		//returns updated head
		return head;
	}

}
