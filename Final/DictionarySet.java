public class DictionarySet implements SetInterface<Integer>{
    MyDictionary dict = new MyDictionary();
    // Integer[] dict.arr = new Integer[10];
    // int dict.last = 0;

    public DictionarySet(Integer[] startArr) {
        FinalPair[] temp = new FinalPair[startArr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new FinalPair(startArr[i], false);
            dict.last++;
        }
        dict.arr = temp;
    }
    public DictionarySet() {
    }

    @Override
    public boolean add(Integer newEntry) {
        if (!this.contains(newEntry)) {
            dict.arr[dict.last].key = newEntry;
            dict.last++;

            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Integer anEntry) {
        for (int i = 0; i < dict.arr.length; i++) {
            if (dict.arr[i].key == anEntry) {
                dict.arr[i].key = dict.arr[dict.last - 1].key;

                // 3- decrement dict.last by 1
                dict.last--;

                return true;
            }
        }
        return false;
    }

    @Override
    public Integer remove() {
        if (dict.last > 0) {
            int temp = dict.arr[dict.last-1].key;
            dict.last--;
            return temp;
        }
        else {
            return null;
        }
        
    }

    @Override
    public boolean contains(Integer anEntry) {
        for (int i = 0; i < dict.arr.length; i++) {
            if (dict.arr[i].key == anEntry) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        dict.last = 0;
        
    }

    @Override
    public int getCurrentSize() {
        return dict.last;
    }

    @Override
    public boolean isEmpty() {
        if (dict.last == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Integer[] toArray() {
        // already storing values in an array but i'll do it the long way
        // System.out.println("dict.last: "+ dict.last);
        if (dict.last > 0) {
            // System.out.println("making array");
            Integer[] returnArray = new Integer[dict.last];

            for (int i = 0; i < dict.last; i++) {
                // System.out.println(dict.arr[i].key);
                returnArray[i] = dict.arr[i].key;
            }
            // System.out.println("array length in to array: " + returnArray.length);
            return returnArray;
        }
        
        return null;
    }

    Integer[] resize(Integer[] arr) {
        // creates larger array
        Integer[] new_arr = new Integer[arr.length + 1];
        // copy old array to new array
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        return new_arr;
    }

    @Override
    public SetInterface<Integer> union(SetInterface<Integer> anotherSet) {
        Integer[] anotherArray = anotherSet.toArray();
        
        Integer[] returnArray = new Integer[dict.last];
        int pos = 0;

        for (int i = 0; i < returnArray.length; i++) {
            
            returnArray[i] = dict.arr[i].key;
            pos++;
        }
        boolean found = false;

        for (int i = 0; i < anotherArray.length; i++) {
            for (int j = 0; j < returnArray.length; j++) {
                if (anotherArray[i] == returnArray[j]) {
                    found = true;
                    break;
                }
            }
            if(found == false) {
                returnArray = resize(returnArray);
                returnArray[pos] = anotherArray[i];

                pos++;
            }
            else {
                found = false;
            }

        }
        return new DictionarySet(returnArray);
    }

    @Override
    public SetInterface<Integer> intersection(SetInterface<Integer> anotherSet) {
        Integer[] anotherArray = anotherSet.toArray();
        
        Integer[] returnArray = new Integer[1];
        int pos = 0;
        for (int i = 0; i < dict.last; i++) {
            for (int j = 0; j < anotherArray.length; j++) {
                if(dict.arr[i].key == anotherArray[j]) {
                    returnArray = resize(returnArray);
                    returnArray[pos] = dict.arr[i].key;
                    pos++;
                    break;
                }
            }
        }

        return new DictionarySet(returnArray);
    }
    
}
