#pragma once
#include <iostream>
class Node {
public:
    Node(int data = 0) : data(data), next(nullptr) {}
    ~Node() {
        std::cout << "deleting node with value: " << data << std::endl;
    }
    int data{};
    Node* next;
};

class QueLinkedList {
public:
    QueLinkedList() : front(nullptr), back(nullptr) {}

    void insert(int val);
    int peek();
    int remove();

    Node* front;
    Node* back;
    // int size;
};