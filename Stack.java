package com.dhruv.Stack;

public class Stack {

	static class Node {
		Node prev;
		int data;
		Node next;

		Node(int data) {
			prev = null;
			this.data = data;
			next = null;
		}
	}

	Node top;
	Node last;

	public Stack(Node node) {
		this.top = node;
	}

	// Stack Implementation using linked List
	public Stack(int[] arr) {
		if (arr.length == 0)

		{
			System.out.println("Input array is empty");
		} else {
			top = new Node(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				push(arr[i]);
			}
		}
	}

	// Method to push element in stack
	public void push(int data) {
		Node temp = new Node(data);
		if (last == null) {
			last = temp;
		} else {
			last.next = temp;
			temp.next = null;
			temp.prev = last;
			last = temp;
		}
	}

	// Method to pop element in stack
	public int pop() {
		if (last == null) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			int data = last.data;
			if (last.prev != null) {
				last = last.prev;
			} else {
				last.next = null;
				last = null;
			}

			return data;
		}
	}

	// Method to display all elements in stack
	public void displayStack() {
		if (last == null) {
			System.out.println("Stack is empty");
			return;
		} else {
			Node p = last;
			while (p != null) {
				System.out.print(p.data + " ");
				p = p.prev;
			}
		}
		System.out.println("");
	}

	// Method to peak last element
	public int peak() {
		if (top == null) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return last.data;

		}
	}

}
