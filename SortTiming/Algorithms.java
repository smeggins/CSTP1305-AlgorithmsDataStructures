public class Algorithms {
    static int binary_search(Integer arr[], int target) {
        int lower = 0;
        int upper = arr.length - 1;

        while (lower < upper) {
            int middle = (lower + upper) / 2;
            if (arr[middle] == target)
                return middle;
            else {
                if (target < arr[middle]) {
                    upper = middle - 1;
                } else {
                    lower = middle + 1;
                }
            }
        }
        return -1;
    }

    // if the target not found, reutrn -1
    static int linear_search(Integer[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }


    static void mergesort(Integer[] arr, Integer[] tmpArr, int firstIndex, int lastIndex) {

//        if(firstIndex < lastIndex){
//            int middle = (firstIndex + lastIndex )/ 2;
//            mergesort(arr, tmpArr, firstIndex, middle);
//            mergesort(arr, tmpArr,middle + 1,lastIndex );
//            merge(arr,  tmpArr, firstIndex, middle, middle + 1, lastIndex);
//            System.arraycopy(tmpArr, firstIndex, arr, firstIndex, lastIndex - firstIndex + 1 );
//        }

        int length = 1;
        while (length < arr.length) {
            int i = 0;
            while (i <= lastIndex) {
                int L1 = i;
                int R1 = L1 + length - 1;
                int L2 = R1 + 1;
                int R2 = L2 + length - 1;

                if (L2 > lastIndex + 1)
                    break;

                // out of bound R2
                if (R2 > lastIndex)
                    R2 = lastIndex;

                merge(arr, tmpArr, L1, R1, L2, R2);
                System.arraycopy(tmpArr, L1, arr, L1, R2 - L1 + 1);

                i += (2 * length);
            }
            length *= 2;
        }
    }

    static void merge(Integer[] arr, Integer[] tmpArr, int firstArrayFirstIndex, int firstArrayLastIndex,
                      int secondArrayFirstIndex, int secondArrayLastIndex) {

        int index = firstArrayFirstIndex;
        while (firstArrayFirstIndex <= firstArrayLastIndex &&
                secondArrayFirstIndex <= secondArrayLastIndex) {
            // equality is for merging arrays of size 1
            if (arr[secondArrayFirstIndex] < arr[firstArrayFirstIndex]) {
                tmpArr[index] = arr[secondArrayFirstIndex];
                secondArrayFirstIndex++;
            } else if (arr[firstArrayFirstIndex] < arr[secondArrayFirstIndex]) {
                tmpArr[index] = arr[firstArrayFirstIndex];
                firstArrayFirstIndex++;
            }
            index++;
        }
        while (firstArrayFirstIndex <= firstArrayLastIndex) {
            tmpArr[index] = arr[firstArrayFirstIndex];
            firstArrayFirstIndex++;
            index++;
        }
        while (secondArrayFirstIndex <= secondArrayLastIndex) {
            tmpArr[index] = arr[secondArrayFirstIndex];
            secondArrayFirstIndex++;
            index++;
        }
    }

    // post-condition: this function print out the sorted array of the input
    // post-condition: this function should not alter the original array
    static void selectionSort(Integer [] arr){
        // 1- find the smallest element in the unsorted part of the array
        int smallest_index;
        for(int i = 0; i < arr.length ; i++){
            smallest_index = i;
            for (int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < arr[smallest_index]){
                    smallest_index = j;
                }
            }
            // 2 - swap this smallest with the first element of the unsorted part of the array
            int tmp = arr[smallest_index];
            arr[smallest_index] = arr[i];
            arr[i] = tmp;
        }

//        for(int x = 0 ; x < arr.length; x++){
//            System.out.print(arr[x] + " ");
//        }

    }


    // post-condition: this function print out the sorted array of the input
    // post-condition: this function should not alter the original array
    static void insertionSort(Integer arr[]){
        for(int current_index_unsorted = 0 ; current_index_unsorted < arr.length; current_index_unsorted++){
            int tmp = arr[current_index_unsorted];
            // look up step, trying to find where to insert the current item
            int iterator = current_index_unsorted;
            while( iterator > 0 && tmp < arr[iterator -1]){
                arr[iterator] = arr[iterator -1];
                iterator --;
            }
            arr[iterator]= tmp; //Insertion step
        }

//        for(int x = 0 ; x < arr.length; x++){
//            System.out.print(arr[x] + " ");
//        }
    }

    // public static void main(String args[]) {
    //     System.out.println("test");

    //     Integer[] arr = new Integer[] {3, 1, 2, 4};

    //     for (Integer integer : arr) {
    //         System.out.println(integer);
    //     }

    //     mergesort(arr, tmpArr, firstIndex, lastIndex);
    // }

}