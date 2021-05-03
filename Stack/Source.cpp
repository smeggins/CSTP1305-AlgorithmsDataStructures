#include "Header.h"



void MyStack::push(int a) {
	arr[top + 1] = a;
	++top;
}
int MyStack::pop() {
	int val = arr[top];
	--top;
	return val;
}
int MyStack::peek() {
	return arr[top];
}