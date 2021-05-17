public class PriorityQueCircularArray {
    
    int[] arr = new int[8];
    int last_index;

    PriorityQueCircularArray() {
        last_index = -1;
    }

    void insert(int val) {
        arr[last_index + 1] = val;
        last_index++;
    }

    int peek() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < last_index + 1; i++) {
            if (arr[i] <= min) {
                min = arr[i];
            }
        }
        return min;
    }

    void remove() {
        int min = arr[0];
        int min_index = 0;
        for (int i = 1; i < last_index + 1; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        swap(min_index, last_index, arr);
        last_index--;
    }

    void swap(int swap_index, int last_index, int[] theArr) {
        int tmp = theArr[swap_index];
        theArr[swap_index] = theArr[last_index];
        theArr[last_index] = tmp;
    }

    

    public static void main(String[] args) throws Exception {
        System.out.println("PriorityQueCircularArray: ");
        PriorityQueCircularArray que = new PriorityQueCircularArray();
        que.insert(5);
        que.insert(6);
        que.insert(2);
        que.insert(4);
        que.insert(1);
        que.insert(3);
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
    }
}

