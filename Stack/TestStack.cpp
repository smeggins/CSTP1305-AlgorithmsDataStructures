#include <iostream>
#include "Header.h"
using namespace std;

int main() {
	cout << "this is a test\n";
	MyStack aStack;
	aStack.push(1);
	aStack.push(7);
	aStack.push(2);
	aStack.push(5);
	aStack.pop();
	aStack.push(4);
	cout << aStack.peek();

	return 0;
}