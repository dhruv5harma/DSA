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

	public void displayRecursive(Node next) {
		if (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
			displayRecursive(head);
		}
	}

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

	public int sum() {
		int sum = 0;
		Node temp = head;
		while (temp != null) {
			sum += temp.data;
			temp = temp.next;
		}
		return sum;
	}

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

}
