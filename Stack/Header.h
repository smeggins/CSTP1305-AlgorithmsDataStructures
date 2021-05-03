#pragma once
class MyStack {

public:
	MyStack() {
		top = -1;
	}

	void push(int a);
	int pop();
	int peek();

private:
	int arr[100];
	int top{};
};