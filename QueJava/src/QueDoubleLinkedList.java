class TWNode {
    int data;
    TWNode next;
    TWNode last;

    TWNode() {
        data = 0;
        next = null;
        last = null;
    }
    TWNode(int d) {
        data = d;
    }
    TWNode(int d, TWNode n) {
        data = d;
        next = n;
    }
    TWNode(int d, TWNode l, TWNode n) {
        data = d;
        last = l;
        next = n;
    }
}

public class QueDoubleLinkedList {
    
    TWNode front;
    TWNode back;
    // int size;

    QueDoubleLinkedList() {
        front = null;
        back = null;
    }

    void insertFront(int val) {
        if (front == null) {
            TWNode newTWNode = new TWNode(val);
            front = newTWNode;
            back = newTWNode;
        }
        else {
            TWNode newTWNode = new TWNode(val, front);
            front.last = newTWNode;
            front = newTWNode;
        }
    }

    void insertBack (int val) {
        if (front == null) {
            TWNode newTWNode = new TWNode(val);
            front = newTWNode;
            back = newTWNode;
        }
        else {
            TWNode newTWNode = new TWNode(val, back, null);
            back.next = newTWNode;
            back = newTWNode;
        }
    }

    int peekFront() {
        int returnval = -1;
        if (front != null) {
            returnval = front.data;
        }
        return returnval;
    }

    int peekBack() {
        int returnval = -1;
        if (back != null) {
            returnval = back.data;
        }
        return returnval;
    }

    int removeFront() {
        int d = -1;
        if (front!= null) {
            d = front.data;
            if (front == back) {
                front = null;
                back = null;
            }
            else {
                front = front.next;
                if (front != null) {
                    front.last = null;
                }
            }
        }
        else {
            System.out.println("List Empty!");
        }
        
        return d;
    }

    int removeBack() {
        int d = -1;
        if (back!= null) {
            d = back.data;
            if (front == back) {
                front = null;
                back = null;
            }
            else {
                back = back.last;
                if (back != null) {
                    back.next = null;
                }
            }
        }
        else {
            System.out.println("List Empty!");
        }
        
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("QueTwoWayLinkedList: ");
        QueDoubleLinkedList que = new QueDoubleLinkedList();
        que.insertFront(4);
        System.out.println("front: " + que.front.data);
        que.insertFront(3);
        System.out.println("front: " + que.front.data);
        que.insertFront(2);
        System.out.println("front: " + que.front.data);
        que.insertFront(1);
        System.out.println("front: " + que.front.data);

        que.insertBack(5);
        System.out.println("back: " + que.back.data);
        que.insertBack(6);
        System.out.println("back: " + que.back.data);
        que.insertBack(7);
        System.out.println("back: " + que.back.data);
        que.insertBack(8);
        System.out.println("back: " + que.back.data);

        que.removeFront();
        System.out.println("front after remove: " + que.front.data);
        que.removeBack();
        System.out.println("back after remove: " + que.back.data);
        System.out.println("Peek Front: " + que.peekFront());
        System.out.println("Peek Back: " + que.peekBack());
        que.removeFront();
        que.removeFront();
        que.removeFront();
        que.removeFront();
        que.removeBack();
        que.removeBack();
        que.removeBack();
        
    }
}

