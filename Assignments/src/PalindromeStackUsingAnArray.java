public class PalindromeStackUsingAnArray {

    PalindromeStackUsingAnArray() {
        top = -1;
    }

    private char[] arr = new char[2]; 
    public int top;

    
    void resize() {
        // Doubles array size
        char[] resizeArr = new char[arr.length * 2];

        // copy old array to new array
        for (int i = 0; i < arr.length; i++) {
            resizeArr[i] = arr[i];
        }
        arr = resizeArr;
    }

    void resize(int n) {
        // increases array size by n
        char[] resizeArr = new char[arr.length + n];

        // copy old array to new array
        for (int i = 0; i < arr.length; i++) {
            resizeArr[i] = arr[i];
        }
        arr = resizeArr;
    }

    public void push(char a) {
        // adds an item to the top of the stack, resizing the array if it is full
        
        // compare new items index pos against max index pos of array
        if ((top + 1) > arr.length -1) {
            resize();
        }
        arr[top + 1] = a;
        ++top;
    }

    public int pop() {
        // removes and returns the top item in the stack
        int val = -1;
        if (top >= 0) {
            val = arr[top];
            --top;   
        }
        return val;
    }

    public int peek() {
        // returns top item on stack
        return arr[top];
    }

    public boolean isEmpty() {
        // checks if stack is empty and returns bool
        return top == -1;
    }

    public void clear() {
        // removes all items in stack
        while (top != -1) {
            pop();
        }
    }

    public void display() {
        // prints all items in the stack if stack is not empty
        if (top != -1) {
            for (int i = 0; i < (top + 1); i++) {
                System.out.println("value " + (i+1) + " is: " + arr[i]);
            }
        }
        else {
            System.out.println("Stack Empty!");
        }
    }

    public void remove(int n) {
        //remove top n entries if n entries exist
        if (top >= n) {
            top -= n;
        }
        else {
            top = -1;
        }
    }

    public boolean isPalendrome() {
        boolean isPal = true;
        for (int i = 0; i < (arr.length / 2); i++) {
            if(arr[i] != arr[(arr.length / 2)-i]) {
                isPal = false;
            }
        }
        return isPal;
    }

    public static void main(String[] args) throws Exception {
        PalindromeStackUsingAnArray aStack = new PalindromeStackUsingAnArray();
        
        System.out.println("is it empty: " + aStack.isEmpty());
        aStack.push('A');
        System.out.println("Push::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        System.out.println("is it empty: " + aStack.isEmpty());
        aStack.push('B');
        System.out.println("Push::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        aStack.push('C');
        System.out.println("Push::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        aStack.push('B');
        System.out.println("Push::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        aStack.push('R');
        System.out.println("Push::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        System.out.println("is Palendrome: " + aStack.isPalendrome());
        aStack.pop();
        System.out.println("Pop::array pos: " + aStack.top + ", value: " + aStack.arr[aStack.top]);
        System.out.println("peek: " + aStack.peek());
        System.out.println("display: ");
        aStack.display();

        System.out.println("Remove 2 items from stack");
        aStack.remove(2);
        aStack.display();

        System.out.println("clear stack");
        aStack.clear();
        aStack.display();
        System.out.println("Pop::array pos: " + aStack.top + ", value: " );
        System.out.println("is it empty: " + aStack.isEmpty());
    }
}
