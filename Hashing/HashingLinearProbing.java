public class HashingLinearProbing {
    //if the hashed array position is used, simply use 
    // the next availible array position
    
    StringPair[] arr;

    HashingLinearProbing() {
        arr = new StringPair[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringPair();
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

    public int probe(String key) {
        boolean found = false;
        int availibleIndex = -1;
        int resultIndex = getHash(key);

        while (!found && arr[resultIndex].status != Occupancy.empty) {
            if (arr[resultIndex].status != Occupancy.availible) {
                if (arr[resultIndex].key == key) {
                    found = true;
                }
                else {
                    resultIndex = (resultIndex +1) % arr.length;
                }
            }
            else {
                if(availibleIndex == -1) {
                    availibleIndex = resultIndex;
                }

                resultIndex = (resultIndex +1) % arr.length;
            }
        }

        if(found || availibleIndex == -1) {
            return resultIndex;
        }
        else {
            return availibleIndex;
        }
    }


//////////////////////////////Dictionary Component/////////////////////////////


    public void insert(String key, String value) {
        arr[probe(key)] = new StringPair(key, value);
    } 

    public void remove(String key) {
        int index = probe(key);
        if ( arr[index].key == key) {
            arr[index].status = Occupancy.availible;
        }
    }

    public String lookup (String key) throws KeyNotFoundException {
        int index = probe(key);
        if ( arr[index].status == Occupancy.occupied) {
            return arr[index].value;
        }
        else {
            throw new KeyNotFoundException("Key not found");
        }
    }

    public void modify (String key, String value) throws KeyNotFoundException {
        int index = probe(key);
        if ( arr[index].status == Occupancy.occupied) {
            arr[index].value = value;
        }
        else {
            throw new KeyNotFoundException("Your key was not found");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("test: ");

        try {
            HashingLinearProbing testDic = new HashingLinearProbing();
            testDic.insert("1", "phil");
            testDic.insert("2989", "karen");
            testDic.insert("3", "james");
            testDic.insert("4", "jimjam");
    
            System.out.println(testDic.lookup("4"));
    
            System.out.println(testDic.lookup("2989"));
            testDic.modify("2989", "Brock");
            System.out.println(testDic.lookup("2989"));
            testDic.remove("2989");
            System.out.println(testDic.lookup("2989"));
        }
        catch (KeyNotFoundException obj) {
            System.out.println(obj.getMessage());
        }
    }
}