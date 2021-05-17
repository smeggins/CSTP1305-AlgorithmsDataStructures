class Node {
    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }
    Node(int d, Node n) {
        data = d;
        next = n;
    }
}

public class QueLinkedList {
    
    Node front;
    Node back;
    // int size;

    QueLinkedList() {
        front = null;
        back = null;
    }

    void insert(int val) {
        Node newNode = new Node(val, null);
        if (front == null) {
            front = newNode;
            back = newNode;
        }
        else {
            back.next = newNode;
            back = newNode;
        }
    }

    int peek() {
        return front.data;
    }

    int remove() {
        int d = front.data;
        front = front.next;
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("QueLinkedList: ");
        QueLinkedList que = new QueLinkedList();
        que.insert(34);
        que.insert(67);
        que.remove();
        que.remove();
        que.insert(11);
        que.insert(23);
        que.insert(9);
        que.insert(71);
        que.insert(56);
        que.insert(22);
        que.insert(4);
        System.out.println(que.peek());
        System.out.println(que.back.data);
    }
}

