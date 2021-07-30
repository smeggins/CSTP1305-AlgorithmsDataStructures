import java.io.Console;

class HashingNode {
    StringPair pair;
    HashingNode next;

    public HashingNode() {
        // pair = new StringPair();
    }

    public HashingNode(StringPair a_pair) {
        pair = a_pair;
    }

    public HashingNode(StringPair a_pair, HashingNode a_next) {
        pair = a_pair;
        next = a_next;
    }
}

public class HashingSeparateChaining {
     //if the hashed array position is used, simply use 
    // the next availible array position
    
    HashingNode[] arr;

    HashingSeparateChaining() {
        arr = new HashingNode[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HashingNode();
        }
    }

    public int hashCode(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }

        return hash;
    }

    public int getHash(String key) {
        return hashCode(key) % arr.length;
    }

//////////////////////////////Dictionary Component/////////////////////////////


    public void insert(String key, String value) {
        HashingNode node = arr[getHash(key)];
        if (node.pair == null) {
            node.pair = new StringPair(key, value);
        }
        else {
            while (node.next != null) {
                if (node.pair.key == key) {
                    // if the key already exists then we shouldn't insert
                    // note the above refers to the internal key not the index
                    return;
                }
                node = node.next;
            }
            node.next = new HashingNode(new StringPair(key, value));
        }
    } 

    public void remove(String key) {
        int index = getHash(key);
        HashingNode node = arr[index];

        // if the first nodes pair hasn't been instantiated then there is nothing to remove at this position
        if (node.pair == null) {
            return;
        }

        //if the first node found holds our data
        if (node.pair.key == key) {
            // if its the only node remove its data
            if (node.next == null) {
                arr[index].pair.key = "";
                arr[index].pair.value = "";
            }
            // otherwise link array directly to the next node
            else {
                arr[index] = node.next;
            }
            return;
        }

        while (node.next != null) {
            if (node.next.pair.key == key) {
                // clip the found node out of the linked list
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
        // if item is not found 
    }

    public String lookup (String key) throws KeyNotFoundException {
        HashingNode node = arr[getHash(key)];
        String value = "Item Not Found";

        try {
            // if the first nodes pair hasn't been instantiated then there is nothing to lookup at this position
            if (node.pair == null) {
                throw new KeyNotFoundException("Key not found");
            }

            if (node.pair.key == key) {
                value = node.pair.value;
            }
            else {
                
                while (node.next != null) {
                    if (node.next.pair.key == key) {
                        value = node.next.pair.value;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        catch (KeyNotFoundException k) {
            System.err.println(k.getLocalizedMessage());
        }
        
        return value;
    }

    public void modify (String key, String value) throws KeyNotFoundException {
        HashingNode node = arr[getHash(key)];

        try {
            // if the first nodes pair hasn't been instantiated then there is nothing to lookup at this position
            if (node.pair == null) {
                throw new KeyNotFoundException("Key not found");
            }

            if (node.pair.key == key) {
                node.pair.value = value;
            }
            else {
                
                while (node.next != null) {
                    if (node.next.pair.key == key) {
                        node.next.pair.value = value;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        catch (KeyNotFoundException k) {
            System.err.println(k.getLocalizedMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("test: ");

        try {
            HashingSeparateChaining testDic = new HashingSeparateChaining();
            testDic.insert("1", "phil");
            testDic.insert("3", "james");
            testDic.insert("4", "jimjam");

            testDic.insert("2989", "karen");
            testDic.insert("2", "brigs");

            System.out.println(" lookup key '4': value = " + testDic.lookup("4"));

            System.out.println("\n Hashing Conflict solved by chaining:");
            System.out.println("  (2989, karen) hashed index is: " + testDic.getHash("2989"));
            System.out.println("  (2, brigs) hashed index is: " + testDic.getHash("2"));

            System.out.println("  lookup key '2989': value = " + testDic.lookup("2989"));
            System.out.println("  lookup key '2': value = " + testDic.lookup("2"));
            testDic.modify("2989", "Brock");
            System.out.println("\n  lookup key '2989'after changing value to Brock: value = " + testDic.lookup("2989"));
            System.out.println("  lookup key '2' is unaffected by change even though it is at the same index: value = " + testDic.lookup("2"));
            testDic.modify("2", "Winona");
            System.out.println("\n  lookup key '2989' should still be Brock: value = " + testDic.lookup("2989"));
            System.out.println("  lookup key '2' after changing value to Winona: value = " + testDic.lookup("2"));
            testDic.remove("2989");
            System.out.println("\n  lookup key '2989' after deleting value: value = " + testDic.lookup("2989"));
            System.out.println("  lookup key '2' is again unaffected: value = " + testDic.lookup("2"));
            
            
        }
        catch (KeyNotFoundException obj) {
            System.out.println(obj.getMessage());
        }
    }
}
