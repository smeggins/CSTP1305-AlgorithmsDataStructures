#pragma once
class Node {
public:
	Node(int data = 0) : data(data), next(nullptr){}
	int data{};
	Node* next;
};

class MyStackLinkedList {

public:
	MyStackLinkedList() : top(nullptr) {

	}

	void push(int a);
	int pop();
	int peek();

private:
	Node* top;
};