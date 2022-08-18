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

	// Method to reverseLinkedList using recursion
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

	//Method to merge two linkedlist
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

}
