class FinalPair {
    Integer key;
    Boolean value;

    public FinalPair(Integer a_key, Boolean a_val) {
        key = a_key;
        value = a_val;
    }

    public FinalPair() {
        key = null;
        value = null;
    }
}

public class MyDictionary implements DictionaryInterface<Integer, Boolean> {
    FinalPair[] arr = new FinalPair[100];
    int last = 0;

    public MyDictionary(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new FinalPair();
        }
    }

    @Override
    public boolean isEmpty() {
        if(last <= 0) {
            return true;
        }

        return false;
    }

    @Override
    public int getSize() {
        
        return last;
    }

    @Override
    public void clear() {
        last = 0;
    }

    @Override
    public Boolean add(Integer key, Boolean value) {
        arr[last] = new FinalPair(key, value);
        last++;
        return arr[last].value;
    }

    @Override
    public Boolean remove(Integer key) {
         // 1 - find the index of the provided key
         int i;
         for( i = 0 ; i < last; i++){
             if(arr[i].key.equals(key)) {
                 Boolean returnval = arr[i].value;
                 // 2- swap the value of that index with the value of the last index
                 arr[i].key = arr[last - 1].key;
                 arr[i].value = arr[last - 1].value;
 
                 // 3- decrement last by 1
                 last--;
 
                 return  returnval;
             }
         }
 
         return null;
    }

    @Override
    public Boolean getValue(Integer key) {
        for( int i = 0 ; i < last; i++){
            if(arr[i].key.equals(key))
                return (Boolean)arr[i].value;
        }
        return null;
    }

    @Override
    public boolean contains(Integer key) {
        for( int i = 0 ; i < last; i++){
            if(arr[i].key.equals(key))
                return true;
        }
        return false;
    }
    
}
