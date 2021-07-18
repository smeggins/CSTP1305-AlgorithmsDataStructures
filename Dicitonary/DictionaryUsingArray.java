import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryUsingArray {

    Pair[] arr = new Pair[10];
    int last = 0;

    void insert(int key, String val) {
        arr[last] = new Pair(key, val);
        last++;
    } 

    void remove(int key) {
        int i;
        for (i = 0; i < last; i++) {
            if(arr[i].key == key) {
                // System.out.println("key: " + key);
                // System.out.println("remove index: " + i);
                // System.out.println("remove: " + arr[i].val);
                // System.out.println("last: " + arr[last - 1]);
                break;
            }
        }

        arr[i].key = arr[last-1].key;
        arr[i].val = arr[last-1].val;

        last--;
    }

    String lookup (int key) {
        for (int i = 0; i < last; i++) {
            if(arr[i].key == key) {
                return arr[i].val;
            }
        }

        return null;
    }

    void modify (int key, String value) {
        for (int i = 0; i < last; i++) {
            if(arr[i].key == key) {
                arr[i].val = value;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println("test: ");
        DictionaryUsingArray testDic = new DictionaryUsingArray();
        testDic.insert(1, "phil");
        testDic.insert(2989, "karen");
        testDic.insert(3, "james");
        testDic.insert(4, "jimjam");

        System.out.println(testDic.lookup(4));

        System.out.println(testDic.lookup(2989));
        testDic.modify(2989, "Brock");
        System.out.println(testDic.lookup(2989));
        testDic.remove(2989);
        System.out.println(testDic.lookup(2989));

    }
}
