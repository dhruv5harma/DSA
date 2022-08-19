package com.dhruv.LinkedList;

/**
 * @author dhruv
 *
 */
public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	LinkedList() {

	}

	LinkedList(Node node) {
		this.head = node;
	}

	LinkedList(int[] arr) {
		if (arr.length == 0) {
			System.out.println("Invalid array");
		} else {
			head = new Node(arr[0]);
			Node temp = head;
			for (int i = 1; i < arr.length; i++) {
				Node node = new Node(arr[i]);
				temp.next = node;
				temp = node;
			}
		}
	}

	// method to add elements in Linked List
	public void add(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node node = new Node(data);
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}

	}

	// Method to display elements of LinkedList
	public void display() {
		if (head == null) {
			System.out.println("Linkedlist is empty");
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("");
	}

	// Method to display elements of LinkedList using recursion
	public void displayRecursive(Node next) {
		if (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
			displayRecursive(head);
		}
	}

	// Method to get size of LinkedList
	public int size() {
		int count = 0;
		if (head == null) {
			System.out.println("Linkedlist is empty");
			return count;
		}
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	// Method to get sum of elements of LinkedList
	public int sum() {
		int sum = 0;
		Node temp = head;
		while (temp != null) {
			sum += temp.data;
			temp = temp.next;
		}
		return sum;
	}

	// Method to get largest elements of LinkedList
	public int max() {
		int max = 0;
		Node temp = head;
		while (temp != null) {
			if (max < temp.data) {
				max = temp.data;
			}
			temp = temp.next;
		}
		return max;
	}

	// Method to check if data is present of LinkedList
	public boolean isPresent(int elem) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == elem) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	// Method to add element at given index of LinkedList
	public void add(int index, int data) {
		Node temp = new Node(data);
		Node tempNode = head;
		if (head == null) {
			head = temp;
		} else if (index == 1) {
			temp.next = head;
			head = temp;
		} else {
			for (int i = 1; i < index; i++) {
				tempNode = tempNode.next;
			}
			temp.next = tempNode.next;
			tempNode.next = temp;
		}
	}

	// Method to insert element at index and create LinkedList
	public void insert(int index, int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			if (index == 0) {
				node.next = head;
				head = node;
			} else {
				Node temp = head;
				for (int i = 1; i < index; i++) {
					temp = temp.next;
				}
				node.next = temp.next;
				temp.next = node;
			}
		}
	}

	// Method to insert element at last position LinkedList at constant time
	Node tail;

	public void addAtLast(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	// Method to insert element in sorted LinkedList
	public void insertInSortedList(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else if (data < head.data) {
			node.next = head;
			head = node;
		} else {
			Node temp = head;
			Node tailingPointer = null;
			while (temp != null && temp.data < data) {
				tailingPointer = temp;
				temp = temp.next;
			}
			node.next = tailingPointer.next;
			tailingPointer.next = node;
		}

	}

	// Method to delete first occurrence of element from LinkedList
	public void delete(int data) {
		if (head == null) {
			System.out.println("List is Empty");
		} else if (head.data == data) {
			head = head.next;
		} else {
			Node p = head;
			Node q = null;
			while (p != null) {
				if (p.data == data) {
					q.next = p.next;
					break;
				}
				q = p;
				p = p.next;
			}
		}
	}

	// Method to delete index position
	public int deleteAtIndex(int index) {
		if (head == null) {
			System.out.println("LinkedList is empty");
			return -1;
		} else if (index == 1) {
			int data = head.data;
			head = head.next;
			return data;
		} else {
			Node p = head;
			Node q = null;
			for (int i = 1; i < index; i++) {
				if (p.next == null) {
					System.out.println("Index does not exist");
					return -1;
				}
				q = p;
				p = p.next;
			}
			int data = p.data;
			q.next = p.next;
			return data;
		}
	}

	// Method to check if LinkedList is sorted
	public boolean isSorted() {
		Node p = head;
		int data = 0;
		while (p != null) {
			if (data > p.data) {
				return false;
			}
			data = p.data;
			p = p.next;
		}
		return true;
	}

	// Method to delete duplicate elements from sorted List
	public void deleteDuplicateElemsFromSortedList() {
		Node p = head;
		Node q = head.next;
		while (q != null) {
			if (p.data != q.data) {
				p = q;
				q = q.next;
			} else {
				p.next = q.next;
				q = p.next;
			}
		}
	}

	// Method to reverse Linkedlist using array
	public void reverseListWithArray() {
		Node p = head;
		int[] tempArray = new int[this.size()];
		int i = 0;
		while (p != null) {
			tempArray[i++] = p.data;
			p = p.next;
		}
		p = head;
		--i;
		while (p != null) {
			p.data = tempArray[i--];
			p = p.next;
		}
	}

	// Method to reverse LinkedList using sliding pointer
	public void reverseListUsingSlidingPointers() {
		Node p = head;
		Node q, r;
		q = r = null;
		while (p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		head = q;
	}

	// Method to reverseLinkedList using recursion
	public void reverseListByRecursion(Node q, Node p) {
		if (p != null) {
			reverseListByRecursion(p, p.next);
			p.next = q;
		} else {
			head = q;
		}
	}

	// Method to concat two lists
	public void concat(LinkedList list) {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = list.head;
	}

	// Method to merge two sorted linkedlist
	public void merge(LinkedList list) {
		Node p = head;
		Node q = list.head;
		Node last = null;
		if (p.data < q.data) {
			head = last = p;
			p = p.next;
			last.next = null;
		} else {
			head = last = q;
			q = q.next;
			last.next = null;
		}
		while (p != null && q != null) {
			if (p.data < q.data) {
				last.next = p;
				last = p;
				p = p.next;
				last.next = null;
			} else {
				last.next = q;
				last = q;
				q = q.next;
				last.next = null;
			}
		}
		if (p != null) {
			last.next = p;
		} else {
			last.next = q;
		}
	}

	//Method to check if linked list has loops
	public boolean isLinkedListHasLoops() {
		Node fast = head;
		Node slow = head;
		/*
		 * while (fast != null) { fast = fast.next.next; slow = slow.next; if (fast ==
		 * slow) { return true; } }
		 */
		// fast.next.next.next = fast.next;//to create loop in linked list we can use
		// this
		do {
			fast = fast.next;
			slow = slow.next;
			fast = fast != null ? fast.next : null;
		} while (fast != null && fast != slow);
		return fast == slow;
	}

	// Method to create Circular Linked List
	public LinkedList createCircularList(int arr[]) {
		if (arr.length != 0) {
			Node node = new Node(arr[0]);
			head = node;
			for (int i = 1; i < arr.length; i++) {
				Node temp = new Node(arr[i]);
				node.next = temp;
				node = temp;
			}
			node.next = head;
		}
		return new LinkedList(head);
	}

	// Method to display Circular Linked List
	public void displayCircularList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
		System.out.println("");
	}

	// Method to insert Circular Linked List
	public void insertInCricularList(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			head.next = head;
			return;
		}
		Node temp = head;
		do {
			temp = temp.next;
		} while (temp.next != head);
		node.next = head;
		temp.next = node;
	}

	// Method to insert Circular Linked List at given Index
	public void insertInCricularList(int index, int data) {
		if (head == null) {
			this.insertInCricularList(data);
			return;
		}
		Node node = new Node(data);
		Node temp = head;
		if (index == 0) {
			while (temp.next != head) {
				temp = temp.next;
			}
			head = node;
		} else {
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
		}
		node.next = temp.next;
		temp.next = node;
	}

	// Method to get size of Circular Linked List
	public int sizeOfCircularList() {
		if (head == null) {
			return 0;
		}
		Node temp = head;
		int length = 0;
		do {
			temp = temp.next;
			length++;
		} while (temp != head);
		return length;
	}

	// Method to delete element from Circular Linked List at given Index
	public int deleteFromCircularList(int index) {
		int deletedNodeData = -1;
		if (head == null) {
			return deletedNodeData;
		}
		Node temp = head;
		if (index == 1) {
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = head.next;
			deletedNodeData = head.data;
			head = head.next;
			return deletedNodeData;
		} else {
			for (int i = 1; i < index - 1; i++) {
				temp = temp.next;
			}
			deletedNodeData = temp.next.data;
			temp.next = temp.next.next;
			head = temp;
			return deletedNodeData;
		}
	}

	// static inner class to create node of doubly type
	static class DNode {
		DNode prev;
		int data;
		DNode next;

		DNode(int data) {
			prev = null;
			this.data = data;
			next = null;
		}
	}

	DNode dhead;

	LinkedList(DNode node) {
		this.dhead = node;
	}

	// Method to create Doubly LinkedList
	public LinkedList createDoublyLinkedList(int[] arr) {
		if (arr.length == 0) {
			System.out.println("List is empty");
			return null;
		}
		DNode temp = new DNode(arr[0]);
		dhead = temp;
		DNode dnode;
		for (int i = 1; i < arr.length; i++) {
			dnode = new DNode(arr[i]);
			temp.next = dnode;
			dnode.prev = temp;
			temp = dnode;
		}
		return new LinkedList(dhead);
	}

	// Method to display Doubly LinkedList
	public void displayDoublyList() {
		DNode temp = dhead;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("");
	}

	// Method to get size of Doubly LinkedList
	public int sizeOfDoublyList() {
		if (dhead == null) {
			return 0;
		}
		DNode temp = dhead;
		int length = 0;
		while (temp != null) {
			length++;
			temp=temp.next;
		}
		return length;

	}

}
