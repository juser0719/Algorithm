package com.ssafy.linkedlist;

public class SinglyLinkedList {
	private Node head;
	
	public void addFirstNode (String data) {
		Node newNode = new Node(data,head);
		head = newNode;
	}
	
	public void addLasttNode (String data) {
		if(head==null)
		{
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		
		lastNode.link = newNode;
	}
	
	public Node getLastNode()
	{
		for(Node currNode =head ; currNode!=null ; currNode = currNode.link)
		{
			if(currNode.link == null)
				return currNode;
		}
		return null;
	}
}
