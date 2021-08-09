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
}
