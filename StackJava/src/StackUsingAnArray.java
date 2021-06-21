public class StackUsingAnArray {

    // STACKS ARE LAST IN FIRST OUT
    StackUsingAnArray() {
        top = -1;
    }

    //In java we ALWAYS use new to create an object like in c# and the [] comes before the array name instead of after
    private int[] arr = new int[100]; // declare java
    public int top;

    public void push(int a) {
        arr[top + 1] = a;
        ++top;
    }

    public int pop() {
        int val = arr[top];
        --top;
        return val;
    }

    public int peek() {
        return arr[top];
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
