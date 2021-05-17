public class QueCircularArray {
    
    int[] arr = new int[8];
    int front;
    int back;
    int size;

    QueCircularArray() {
        front = 0;
        back = 0;
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
        System.out.println("QueCircularArray: ");
        QueCircularArray que = new QueCircularArray();
        que.insert(34);
        que.insert(67);
        que.remove();
        que.remove();
        que.insert(11);
        que.insert(23);
        que.insert(9);
        que.insert(71);
        que.insert(56);
        que.insert(22);
        que.insert(4);
        System.out.println(que.peek());
        System.out.println(que.back);
        System.out.println(que.arr[que.back-1]);
    }
}

