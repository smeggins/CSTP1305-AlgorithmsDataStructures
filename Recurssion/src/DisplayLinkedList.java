class ZNode {
    int data;
    ZNode next;

    ZNode(int a) {
        data = a;
        next = null;
    }
}

public class DisplayLinkedList {

    private static void displayListIter(ZNode a) {
        ZNode iter = a;
        while (iter != null) {
            System.out.println(iter.data);
            iter = iter.next;
        }
    }

    private static void displayListRecursive(ZNode a) {
        if (a == null) {
        }
        else {
            System.out.println(a.data);
            displayListRecursive(a.next);
        }
    }

    private static void displayListRecursivelyLasttoFirst(ZNode a) {
        if (a == null) {
        }
        else {
            // NOTE: we switched from last to first here because we are preforming all
            // method calls before we acutually print anything so it will iterate
            // all the way to the last node then it will finish that method call
            // by running the print command, then when it finishes the next method can 
            // finish.... until it reaches the first method call where it then
            // uses that print and closes the last instance of that method.
            displayListRecursivelyLasttoFirst(a.next);
            System.out.println(a.data);
        }
    }

    public static void main(String[] args) {
    
        ZNode a = new ZNode(40);
        ZNode b = new ZNode(50);
        ZNode c = new ZNode(30);
        ZNode d = new ZNode(59);
        ZNode e = new ZNode(33);
        ZNode f = new ZNode(83);
    
        a.next = b;        
        b.next = c;
        c.next = d;
        d.next = e;
        d.next.next = f;

        displayListRecursivelyLasttoFirst(a);
    }
}