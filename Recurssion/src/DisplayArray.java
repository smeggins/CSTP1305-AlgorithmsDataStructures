public class DisplayArray {

    private static void displayArrayRecursive(int[] arr, int start_index, int last_index) {
        System.out.println("startindex: " + arr[start_index]);

        if (start_index < last_index) { 
            displayArrayRecursive(arr, start_index + 1, last_index);
        }
    }

    private static void displayArrayIter(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("startindex: " + arr[i]);    
        }
    }

    private static void displayArrayRecursiveLastToFirst(int[] arr, int last_index) {
        System.out.println("Item: " + arr[last_index]);
        if (last_index != 0) {
            displayArrayRecursiveLastToFirst(arr, last_index - 1);
        }
    }

    private static void displayArrayRecursiveMiddleTreeLToR(int[] arr, int first_index, int last_index) {
        // print middle of each section breakdown,//
        //               -3-                      //
        //        1/             \5               //
        //   0/       \2     4/       \6          //
        ////////////////////////////////////////////
        
        if (first_index == last_index) {
            System.out.println("last Item: " + arr[first_index]);
        }
        else if (last_index > first_index) {
            int middle_index = (first_index + last_index) / 2;

            System.out.println("recur Item: " + arr[middle_index]);

            displayArrayRecursiveMiddleTreeLToR(arr, first_index, middle_index -1);
            displayArrayRecursiveMiddleTreeLToR(arr, middle_index + 1, last_index);
        }
    }

    private static void displayArrayRecursiveMiddleTreeRToL(int[] arr, int first_index, int last_index) {
        // print middle of each section breakdown,//
        //               -4-                      //
        //        2/             \6               //
        //   1/       \3     5/       \7          //
        ////////////////////////////////////////////

        if (first_index == last_index) {
            System.out.println("Last Item: " + arr[first_index]);
        }
        else if (last_index > first_index) {
            int middle_index = (first_index + last_index) / 2;

            System.out.println("recur Item: " + arr[middle_index]);

            displayArrayRecursiveMiddleTreeRToL(arr, middle_index + 1, last_index);
            displayArrayRecursiveMiddleTreeRToL(arr, first_index, middle_index -1);
        }
    }

    public static void main(String[] args) throws Exception {
    
        int[] arr = new int[7];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        // // coundown/up items in array
        // displayArrayRecursive(arr, 0, arr.length-1);
        // displayArrayIter(arr);

        // displayArrayRecursiveLastToFirst(arr, arr.length-1);
        System.out.println("\n\nprinting ltor");
        displayArrayRecursiveMiddleTreeLToR(arr, 0, arr.length-1);
        System.out.println("\n\nprinting rtol");
        displayArrayRecursiveMiddleTreeRToL(arr, 0, arr.length-1);
    }
}