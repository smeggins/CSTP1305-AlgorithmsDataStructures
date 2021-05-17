#include "QueUsingLinkedList.h"

void QueLinkedList::insert(int val) {
    Node* newNode = new Node(val);
    if (front == nullptr) {
        front = newNode;
        back = newNode;
    }
    else {
        back->next = newNode;
        back = newNode;
    }
}

int QueLinkedList::peek() {
    return front->data;
}

int QueLinkedList::remove() {
    int d = front->data;
    front = front->next;
    return d;
}

