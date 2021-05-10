#pragma once
#include <iostream>
class Node {
public:
	Node(int data = 0) : data(data), next(nullptr){}
	~Node() {
		std::cout << "deleting node with value: " << data << std::endl;
	}
	int data{};
	Node* next;
};

class MyStackLinkedList {

public:
	MyStackLinkedList() : top(nullptr) {

	}
	~MyStackLinkedList() {
		while (top != nullptr) {
			pop();
		}
	}

	void push(int a);
	int pop();
	int peek();

private:
	Node* top;
};