package com.greatleraning.main;

import java.util.ArrayList;

class Node{
	int data;
	Node left, right;
	Node(int val){
		data = val;
		left = right = null;
	}
}
public class LongestPath {

	
	static ArrayList<Integer> findLongestPath(Node root){
		//If root is null means there is no binary tree so return a empty vector
		if(root == null) {
			ArrayList<Integer> output = new ArrayList(); 
			return output;
	}
		// Recursion call on root.rightNode
		ArrayList<Integer> rightNode = findLongestPath(root.right);
		
		// Recursion call on root.leftNode
		ArrayList<Integer> leftNode = findLongestPath(root.left);
		
		// Compare the size of the two ArrayList and insert current node accordingly
		if(rightNode.size() < leftNode.size()) {
			leftNode.add(root.data);
		}else {
			rightNode.add(root.data);
		}
		
		// Return the appropriate ArrayList 
			return leftNode.size() > rightNode.size()? leftNode : rightNode;  
			
		
	}
	public static void main(String[] args) {
	Node node1 = new Node(100);
	Node node2 = new Node(20);
	Node node3 = new Node(130);
	Node node4 = new Node(10);
	Node node5 = new Node(50);
	Node node6 = new Node(110);
	Node node7 = new Node(140);
	Node node8 = new Node(5);
	
	
	node4.left = node8;
	node2.left = node4;
	
	node2.right = node5;
	node3.left = node6;
	node3.right = node7;
	
	node1.right = node3;
	node1.left = node2;
	
	 ArrayList<Integer> result = findLongestPath(node1);
	 System.out.print("Longest Path: ");
	 for(int i: reverseArrayList(result)) {
		 System.out.print(i + " -> ");
	 }
}

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
 
            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }
 
        // Return the reversed arraylist
        return revArrayList;
    }

}
