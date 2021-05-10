#include "StackLinkedList.h"



void MyStackLinkedList::push(int a) {
	Node* newNode{ new Node(a) };
	if (top == nullptr) {
		top = newNode;
	}
	else {
		newNode->next = top;
		top = newNode;
	}
}
int MyStackLinkedList::pop() {
	int nodeData{ top->data };
	if (top->next == nullptr) {
		delete(top);
		top = nullptr;
	}
	return nodeData;
}
int MyStackLinkedList::peek() {
	return top->data;
}