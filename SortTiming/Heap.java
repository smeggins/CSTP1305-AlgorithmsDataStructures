import java.util.Arrays;

public class Heap {
    int []arr;
    int last_index = -1;
    Heap(){
        arr = new int[20]; // todo: enlarge()
    }

    Heap(Integer []unordered_array){
        arr = new int[unordered_array.length];
        for (int i = 0; i <unordered_array.length; i++){
            arr[i] = unordered_array[i];
        }
        last_index = unordered_array.length - 1;
    }
    void insert(int x){
        // first step: insert at the end of the array index
        last_index++;
        arr[last_index] = x;

        // second step: Fix the partial ordering
        int iterator = last_index;
        int parent_index = (int) Math.floor((iterator* 1.0 - 1 )  / 2);
        while( parent_index >= 0 && arr[parent_index] < arr[iterator]){
            swap(parent_index, iterator);
            // moving to the next iteration
            iterator = parent_index;
            parent_index = (int) Math.floor((parent_index* 1.0 - 1 )  / 2);
        }
//        last_index++;
    }

    int remove(){
        //        step 1
        //        Make a temporary copy of the root’s data
        int tmp = arr[0];

        // Step 2
        //        Similarly to the insertion algorithm, first ensure that the heap remains complete
        //        Replace the root node with the right-most leaf
        //        i.e. the highest (occupied) index in the array
        arr[0] = arr[last_index];

        // Step 3
        //        Swap the new root with its largest valued child until the partially ordered property holds
        //        i.e. bubble down
        // todo
        int iterator = 0;
        int left_child_index = 2 * iterator  + 1;
        int right_child_index = 2 * iterator  + 2;
        while(left_child_index < last_index) {
            //find the max value child
            int max_child_index = right_child_index;
            if(arr[left_child_index] > arr[right_child_index])
                max_child_index = left_child_index;

            swap(iterator, max_child_index);

            // move the iterator
            iterator = max_child_index;
            left_child_index = 2 * iterator  + 1;
            right_child_index = 2 * iterator  + 2;
        }
        last_index--;
        return tmp;
    }
//   bubbleUP(int index); // todo

    void   bubbleDown(int index){
        //        step 1
        //        Make a temporary copy of the root’s data
//        int tmp = arr[0];

        // Step 2
        //        Similarly to the insertion algorithm, first ensure that the heap remains complete
        //        Replace the root node with the right-most leaf
        //        i.e. the highest (occupied) index in the array
//        arr[0] = arr[last_index];

        // Step 3
        //        Swap the new root with its largest valued child until the partially ordered property holds
        //        i.e. bubble down
        // todo
        int iterator = index;
        int left_child_index = 2 * iterator  + 1;
        int right_child_index = 2 * iterator  + 2;
        while(left_child_index < last_index) {
            //find the max value child
            int max_child_index = right_child_index;
            if(arr[left_child_index] > arr[right_child_index])
                max_child_index = left_child_index;

            swap(iterator, max_child_index);

            // move the iterator
            iterator = max_child_index;
            left_child_index = 2 * iterator  + 1;
            right_child_index = 2 * iterator  + 2;
        }
//        last_index--;
//        return tmp;
    }

//   heapSort(); // todo
    void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    int peek(){
        return arr[0];
    }
    boolean isEmpty(){
        return  last_index == 0;
    }

    void printAll(){
        // 1 - copy the array into a temproray array
        int []tmpArr = new int[this.arr.length];
        for(int i = 0 ; i < this.arr.length; i++){
            tmpArr[i] = arr[i];
        }
        // 2- repeatedly call remove() untill there are no elements left
        while(!isEmpty()){
//            System.out.println(this.remove());
            this.remove();
        }
        // 3- restore the tree or the array
        for(int i =0 ; i<tmpArr.length; i++){
            this.insert(tmpArr[i]);
        }
    }

    void heapSort(){
        while(!isEmpty()){
//            System.out.println(this.remove());
            this.remove();
        }
    }
    public static void main(String args[]){


        Heap obj = new Heap(new Integer[]{9, 10, 13, 65, 44, 23, 86, 98, 41, 32, 17, 21, 29});
//        obj.insert(9);
//        obj.insert(10);
//        obj.insert(13);
//        obj.insert(65);
//        obj.insert(44);
//        obj.insert(23);
//        obj.insert(86);
//        obj.insert(98);
//        obj.insert(41);
//        obj.insert(32);
//        obj.insert(17);
//        obj.insert(21);
//        obj.insert(29);
//        System.out.println(obj.peek());// return 94
//        obj.remove();
//        obj.printAll(); // lab work: implement this method without destroying the heap array
//        obj.heapSort();
        obj.heapSortUsingBubbleDown();

    }

    private void heapSortUsingBubbleDown() {
        // Heapify the array
        int counter = (last_index + 1) /2;
        while(counter >= 0){
            bubbleDown(counter);
            counter--;
        }
        // Repeatedly remove the root
        while(!isEmpty()){
            System.out.println(this.remove());
        }
    }
}