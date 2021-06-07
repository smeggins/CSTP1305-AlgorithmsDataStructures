class Node{
    int data;
    Node next;
    Node(int a){
        data = a;
        next = null;
    }

}

public class DisplayLinkedList {

    private static void displayListIter(Node a) {
        Node iter = a;
        while (iter != null) {
            System.out.println(iter.data);
            iter = iter.next;
        }
    }

    private static void displayListRecursive(Node a) {
        if (a == null) {
        }
        else {
            System.out.println(a.data);
            displayListRecursive(a.next);
        }
    }

    private static void displayListRecursivelyLasttoFirst(Node a) {
        if (a == null) {
        }
        else {
            displayListRecursivelyLasttoFirst(a.next);
            System.out.println(a.data);
        }
    }

    public static void main(String[] args) {
    
        Node a = new Node(40);
        Node b = new Node(50);
        Node c = new Node(30);
        Node d = new Node(59);
        Node e = new Node(33);
        Node f = new Node(83);
    
        a.next = b;        
        b.next = c;
        c.next = d;
        d.next = e;
        d.next.next = f;

        displayListRecursivelyLasttoFirst(a);
    }
}