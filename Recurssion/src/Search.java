
public class Search {

    static private int linearSearchIterative(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int start_index, int last_index, int target) {
        int middle_index = (start_index + last_index) /2;

        if (start_index > last_index) {
            return -1;
        }
        else if (target == arr[middle_index]) {
            return middle_index;
        }
        else if (target > arr[middle_index]) {
            return binarySearchRecursive(arr, middle_index +1, last_index, target);
        }
        else {
            return binarySearchRecursive(arr, start_index, middle_index-1, target);
        }
        
    }

    public static void main(String[] args) {
        int[] arr = new int[7];
        arr[0] = 20;
        arr[1] = 30;
        arr[2] = 40;
        arr[3] = 59;
        arr[4] = 73;
        arr[5] = 83;
        arr[6] = 90;

        System.out.println(binarySearchRecursive(arr, 0, arr.length-1, 73));
    }
}