class CNode {
    int data;
    CNode next;

    CNode() {
        data = 0;
        next = null;
    }
    CNode(int d, CNode n) {
        data = d;
        next = n;
    }
}

public class QueCircularLinkedList {
    
    CNode front;
    CNode back;
    // int size;

    QueCircularLinkedList() {
        front = null;
        back = null;
    }

    void insert(int val) {
        CNode newCNode = new CNode(val, front); // we use front here because the last item always
                                                // points to the first item in a circular que linked list
        if (front == null) {
            front = newCNode;
            back = newCNode;
        }
        else {
            back.next = newCNode;
            back = newCNode;
        }
    }

    int peek() {
        return front.data;
    }

    int remove() {
        int d = -1;
        if (front != null) {
            d = front.data;
            if (front == back) {
                front = null;
                back = null;
            }
            else {
                front = front.next;
                back.next = front;
            }
        }
        else {
            System.out.println("List Empty!");
        }
        
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("QueCircularLinkedList: ");
        QueCircularLinkedList que = new QueCircularLinkedList();
        que.insert(31);
        System.out.println("front: " + que.front.data);
        System.out.println("back: " + que.back.data);
        que.insert(67);
        System.out.println("front: " + que.front.data);
        System.out.println("back: " + que.back.data);
        que.insert(11);
        System.out.println("remove: " + que.remove());
        System.out.println("remove: " + que.remove());
        System.out.println("front: " + que.front.data);
        System.out.println("back: " + que.back.data);
        System.out.println("remove: " + que.remove());
        System.out.println("remove: " + que.remove());
        que.insert(23);
        que.insert(9);
        que.insert(71);
        que.insert(56);
        que.insert(22);
        que.insert(4);
        System.out.println("peek: " + que.peek());
        System.out.println("back: " + que.back.data);
    }
}

