public class Display {

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
        //               -4-                      //
        //        2/             \6               //
        //   1/       \3     5/       \7          //
        ////////////////////////////////////////////
        if (last_index > first_index) {
            if (first_index == last_index) {
                System.out.println("Item: " + arr[first_index]);
            }
            else {
                int middle_index = (first_index + last_index) / 2;
    
                System.out.println("Item: " + arr[middle_index]);
    
                displayArrayRecursiveMiddleTreeLToR(arr, first_index, middle_index -1);
                displayArrayRecursiveMiddleTreeLToR(arr, middle_index + 1, last_index);
            }
        }
    }

    private static void displayArrayRecursiveMiddleTreeRToL(int[] arr, int first_index, int last_index) {
        // print middle of each section breakdown,//
        //               -4-                      //
        //        2/             \6               //
        //   1/       \3     5/       \7          //
        ////////////////////////////////////////////
        if (last_index > first_index) {
            if (first_index == last_index) {
                System.out.println("Item: " + arr[first_index]);
            }
            else {
                int middle_index = (first_index + last_index) / 2;
    
                System.out.println("Item: " + arr[middle_index]);
    
                displayArrayRecursiveMiddleTreeRToL(arr, middle_index + 1, last_index);
                displayArrayRecursiveMiddleTreeRToL(arr, first_index, middle_index -1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
    
        int[] arr = new int[6];
        arr[0] = 40;
        arr[1] = 50;
        arr[2] = 30;
        arr[3] = 59;
        arr[4] = 33;
        arr[5] = 83;
        // // coundown/up items in array
        // displayArrayRecursive(arr, 0, arr.length-1);
        // displayArrayIter(arr);

        // displayArrayRecursiveLastToFirst(arr, arr.length-1);

        displayArrayRecursiveMiddleTreeLToR(arr, 0, arr.length-1);
        displayArrayRecursiveMiddleTreeRToL(arr, 0, arr.length-1);
    }
}