public class QueUsingResizableArray {
    
    int[] arr = new int[1];
    int front;
    int back;
    int size;

    QueUsingResizableArray() {
        front = 0;
        back = 0;
    }

    void resize() {
        // creates larger array
        int[] new_arr = new int[arr.length + 2];
        // copy old array to new array
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    void insert(int val) {
        arr[back] = val;
        size++;
        back = (front + size) % arr.length;
    }

    int peek() {
        return arr[front];
    }

    int remove() {
        int temp = front;
        front = (front + 1) % arr.length;
        size--;
        return temp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("QueUsingResizableArray: ");
        QueUsingResizableArray que = new QueUsingResizableArray();
        que.insert(34);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(67);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.remove();
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.remove();
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(11);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(23);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(9);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(71);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(56);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(22);
        System.out.println("front: " + que.front + ", back: " + que.back);
        que.insert(4);
        System.out.println("front: " + que.front + ", back: " + que.back);
        System.out.println(que.peek());
        System.out.println(que.back);
        System.out.println(que.arr[que.back-1]);
    }
}

