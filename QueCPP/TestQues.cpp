#include <iostream>
#include "QueUsingArray.h"
#include "QueUsingLinkedList.h"
using namespace std;

int main() {
    cout << "QueLinkedList: ";
    QueLinkedList* que = new QueLinkedList();
    que->insert(34);
    que->insert(67);
    que->remove();
    que->remove();
    que->insert(11);
    que->insert(23);
    que->insert(9);
    que->insert(71);
    que->insert(56);
    que->insert(22);
    que->insert(4);
    cout << "peek: " << que->peek() << endl;
    cout << "back val: " << que->back->data << endl;
    //cout << "last value in que: " << que->arr[que->back - 1] << endl;
    return 0;
}