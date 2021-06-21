public class PracticeCircularQue {
    // circular que means first in first out but it adds things in a circular fashion
    // it adds to index 1,2,3,4.... then removes 1,2,3... then adding top index 8,9,10,0,1,2 and so on
    int[] arr = new int[10];
    int front;
    int back;
    int size; 

    PracticeCircularQue() {
    }

    void insert(int val) {
        if ((front == back && front == 0) || front != back) {
            arr[back] = val;
            size++;
            back = (back + 1) % arr.length;
             
            System.out.println("back value during insert: " + back);
        }
        else {
            System.out.println("array full");
        }
    }

    int peek() {
        return arr[front];
    }

    int remove() {
        int returnval = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return returnval;
    } 

    public static void main(String[] args) throws Exception {
        PracticeCircularQue testQue = new PracticeCircularQue();
        System.out.println("inserting the first 9 values: ");
        testQue.insert(1);
        System.out.println(testQue.peek());
        testQue.insert(2);
        System.out.println(testQue.peek());
        testQue.insert(3);
        System.out.println(testQue.peek());
        testQue.insert(4);
        System.out.println(testQue.peek());
        testQue.insert(5);
        System.out.println(testQue.peek());
        testQue.insert(6);
        System.out.println(testQue.peek());
        testQue.insert(7);
        System.out.println(testQue.peek());
        testQue.insert(8);
        System.out.println(testQue.peek());
        testQue.insert(9);
        System.out.println(testQue.peek());

        System.out.println("removing the first 3 values: ");

        testQue.remove();
        System.out.println("new top value after removal: " + testQue.peek());
        testQue.remove();
        System.out.println("new top value after removal: " + testQue.peek());
        testQue.remove();
        System.out.println("new top value after removal: " + testQue.peek());

        System.out.println("inserting 3 more values to prove back changes to index 0: ");
        testQue.insert(10);
        System.out.println(testQue.peek());
        testQue.insert(11);
        System.out.println(testQue.peek());
        testQue.insert(12);
        System.out.println(testQue.peek());

        System.out.println("Add 3 more values to show that it will show full array: ");
        testQue.insert(12);
        System.out.println(testQue.peek());
        testQue.insert(12);
        System.out.println(testQue.peek());
        testQue.insert(12);
        System.out.println(testQue.peek());
    }
}