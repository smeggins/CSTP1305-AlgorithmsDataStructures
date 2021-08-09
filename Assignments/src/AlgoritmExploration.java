public class AlgoritmExploration {

    static void merge(int[] arr, int start, int mid, int end) {
        
        // this is our temp array
        int[] temp = new int[end - start + 1 ];

        // tracks the index of our left half array
        int leftIndex = start;
        // tracks the index of our right half array
        int rightIndex = mid+1;
        // tracks iterations
        int tempIndex = 0;

        /* 
        because this all happens from the lowest level up because of recurssion the left half 
        and right half will always already be ordered. This is why we can check the first value of
        the left and right sections for the lowest and add that to the temp array with confidence that
        the value we choose will always be the lowest value in either checked side
        */ 
        while (leftIndex <= mid && rightIndex <= end) {
            // if the first item in our left half is less than the first item in the right half
            if (arr[leftIndex] <= arr[rightIndex]) {
                // in the first position of our temp array add the lowest value (ie arr[leftIndex])
                temp[tempIndex] = arr[leftIndex];
                // increment leftIndex so we don't check that value again
                leftIndex += 1;
            }
            else {
                // opposite of above
                temp[tempIndex] = arr[rightIndex];
                rightIndex += 1;
            }
            // increment the next position in our temp array
            tempIndex += 1;
        }

        while (leftIndex <= mid) {
                // in the first position of our temp array add the lowest value (ie arr[leftIndex])
                temp[tempIndex] = arr[leftIndex];
                // increment leftIndex so we don't check that value again
                leftIndex += 1;
                tempIndex += 1;
        }

        while (rightIndex <= end) {
                // opposite of above
                temp[tempIndex] = arr[rightIndex];
                rightIndex += 1;
                tempIndex += 1;
        }

        // finally from the block of the array we are sorting, replace the arr values with the temp values
        for (int i = 0; i < temp.length; i++) {
            arr[i+start] = temp[i];
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        
        // sets our base case parameter
        if (start < end) {

            int mid = (start+end)/2;
            // calls it'self recurssivly extracting t
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
        
    }

    public static void main(String args[]) {
        System.out.println("test");

        int[] arr = new int[] {3, 1, 2, 6, 5, 4};

        for (int integer : arr) {
            System.out.println(integer);
        }
        System.out.println("\n\n");


        mergeSort(arr, 0, arr.length-1);

        for (int integer : arr) {
            System.out.println(integer);
        }
    }

    /*
    merge sort O(nlog(n)):
        this sorting algorithm has n operations during each level of iteration ie:
               8        =8    Level0
              4-4       =8    Level1    
            2-2-2-2     =8    Level2
        1-1-1-1-1-1-1-1 =8    Level3

        the height of this tree is log(n) ie:
        log(8) = 3

        Therefore: 
            Merge Sort = O(nlog(n))
    */

    /*
    Heap Sort O(nlog(n)) (slightly worse complexity than merge sort):
        heap sort first need to create a max or min heap out of the array.
        this action has a complexity of: 
        O(n)

        after this for n times:
        O(n)
        
        we sort though the tree (min/max-heap) adding the larges value to the root
        then swapping that value to the sorted section of the array.
        This has a complexity of:
        O(log(n))

        this becomes :
        O(n+nlog(n))

        simpified it becomes:

        O(nlog(n))
    */

    /*
    Selection sort O(n^2) (slightly worse complexity than insertion sort):
        In selection sort you iterate through the unsorted portion of the array, identifying the lowest/highest
        value, then you add that value to the sorted side and reapeat.

        This means the number of operations will be a complexity of:
        O(n^2)
    */

    /*
    Insertion Sort slightly :
        for instertion sorting you check each value as you come to it in the array against the previous elements
        until it finds a value smaller than the current element or it reaches the root.
        then it shifts all the elements larger than the checked element forward and place the checked element
        in the ordered position.

        This means the number of operations will be a complexity of:
        O(n^2)
    */

    /*
    Order from best to worst time complexity:
    merge sort          O(nlog(n))
    heap sort           O(nlog(n))
    insertion sort      O(n^2)
    selection sort      O(n^2)
    
    NOTE: insertion sort is often faster than merge or heap sort 
    when the array contains fewer elements (specifically 43 or less).
    */
}
