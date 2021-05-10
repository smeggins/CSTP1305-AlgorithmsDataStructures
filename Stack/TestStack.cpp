#include <iostream>
#include "Header.h"
#include "StackLinkedList.h"
using namespace std;

int main() {
	cout << "this is a test\n";
	MyStackLinkedList aStack;
	aStack.push(1);
	aStack.push(7);
	aStack.push(2);
	aStack.push(5);
	aStack.pop();
	aStack.push(4);
	cout << "Peeking at the last value: " << aStack.peek() << endl;

	return 0;
}