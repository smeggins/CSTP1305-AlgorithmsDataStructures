public class PracticePriorityQueArray {
    // priority means that it removes and peeks based on what has priority. in this case we made it the 
    // lowest number. it could be anything though
    
    int[] arr = new int[8];                  
    int last_index;

    PracticePriorityQueArray() {
        last_index = -1;
    }

    void insert(int val) {
        if (last_index < arr.length -1) { // make sure the arr isn't full
            last_index ++;
            arr[last_index] = val; 
        }
        else {
            System.out.println("array full");
        }
    }

    int peek() {
        if (last_index != -1) {
            // we use max value to start with the highest possible number
            int minValue = Integer.MAX_VALUE;
            
            for (int i = 0; i < last_index + 1; i++) { // you need +1 after arr.length to account for 0
                if (arr[i] < minValue) {
                    minValue = arr[i];
                }
            }

            return minValue;
        }
        else {
            System.out.println("Array is empty!");
            return -1;
        }
    }

    void swap(int swap_index, int last_index, int[] theArr) {
        theArr[swap_index] = theArr[last_index];
        
    }

    void remove() {
        if (last_index != -1) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < last_index + 1; i++) { // you need +1 after arr.length to account for 0
                if (arr[i] < minValue) {
                    minValue = arr[i];
                    minIndex = i;
                }
            }
            swap(minIndex, last_index, arr);
            last_index--;
        }
        else {
            System.out.println("Array is empty!");
        }
    }

    

    

    public static void main(String[] args) throws Exception {
        System.out.println("PracticePriorityQueArray: ");
        PracticePriorityQueArray que = new PracticePriorityQueArray();
        que.insert(5);
        que.insert(6);
        que.insert(2);
        que.insert(4);
        que.insert(1);
        que.insert(3);
        que.insert(7);
        que.insert(8);
        que.insert(9);
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.peek());
        que.remove();
        System.out.println("peek: " + que.last_index);
    }
}
