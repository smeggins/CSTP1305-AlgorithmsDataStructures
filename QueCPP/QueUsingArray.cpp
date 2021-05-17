#include "QueUsingArray.h"

void QueCircularArray::insert(int val) {
    arr[back] = val;
    size++;
    back = (front + size) % 8;
}

int QueCircularArray::peek() {
    return arr[front];
}

int QueCircularArray::remove() {
    int temp = front;
    front = (front + 1) % 8;
    size--;
    return temp;
}