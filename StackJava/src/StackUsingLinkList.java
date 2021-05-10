class Node {
    Node(int data) {
        this.data = data;
    }
    int data;
    Node next;
}

public class StackUsingLinkList {

    StackUsingLinkList() {
        top = null;
    }

    public Node top;

    public void push(int a) {
        
        Node newNode = new Node(a);
        // below code is redundant because in java it always initializes an object as null
        newNode.next = null;
        if (top == null) {
            top = newNode;
        }
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        int nodeData = top.data;
        top = top.next;
        return nodeData;
    }

    public int peek() {
        return top.data;
    }

    public static void main(String[] args) throws Exception {
        StackUsingAnArray aStack = new StackUsingAnArray();
         
        aStack.push(1);
        aStack.push(7);
        aStack.push(2);
        aStack.push(5);
        aStack.pop();
        aStack.push(4);
        System.out.println(aStack.peek());
    }
}
