import java.util.Dictionary;
import java.util.Hashtable;



class DictNode {
    Pair pair;
    DictNode next;

    DictNode(Pair a_pair) {
        this.pair = a_pair;
    }

    public void setNextNode(DictNode a_next) {
        this.next = a_next;
    }
 }

public class DictionaryUsingLinkedList {
    DictNode head;

    void insert(int key, String val) {
        Pair pair = new Pair(key, val);
        DictNode newNode = new DictNode(pair);
        
        if(head == null) {
            head = newNode;    
        }
        else {
            DictNode iterator = head;

            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.setNextNode(newNode);
        }
    } 

    String lookup (int key) {
        DictNode iterator = head;
        while (iterator != null) {
            if (iterator.pair.key == key) {
                return iterator.pair.val;
            }
            iterator = iterator.next;
        }
        return null;
    }

    void remove(int key) {
        if (head.pair.key == key) {
            head = head.next;
        }
        else {
            DictNode iterator = head;
            while (iterator.next != null) {
                if (iterator.next.pair.key == key) {
                    iterator.next = iterator.next.next;
                }
                iterator = iterator.next;
            }
        }
    }

    void modify (int key, String value) {
        DictNode iterator = head;
        while (iterator != null) {
            if (iterator.pair.key == key) {
                iterator.pair.val = value;
            }
            iterator = iterator.next;
        }
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println("test: ");
        DictionaryUsingLinkedList testDic = new DictionaryUsingLinkedList();
        testDic.insert(1, "phil");
        testDic.insert(2989, "karen");
        testDic.insert(3, "james");
        testDic.insert(4, "jimjam");

        System.out.println("lookup 4: " + testDic.lookup(4));

        System.out.println("lookup 2989: " + testDic.lookup(2989));
        testDic.modify(2989, "Brock");
        System.out.println("lookup 2989: " + testDic.lookup(2989));
        testDic.remove(2989);
        System.out.println(testDic.lookup(2989));
    }
}
