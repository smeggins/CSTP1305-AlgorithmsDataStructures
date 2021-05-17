#pragma once

class QueCircularArray {

public:
    int arr[8] = { 0 };
    int front;
    int back;
    int size;

    QueCircularArray() {
        front = 0;
        back = 0;
        size = 0;
    }

    void insert(int val);
    int peek();
    int remove();
};