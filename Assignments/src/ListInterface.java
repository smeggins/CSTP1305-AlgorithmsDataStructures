/** An interface for the ADT list.
    Entries in a list have positions that begin with 1.
*/
public interface ListInterface<T>
{
   /** Adds a new entry to the end of this list.
       Entries currently in the list are unaffected.
       The list's size is increased by 1.
       @param newEntry  The object to be added as a new entry. */
   public void add(T newEntry);
   
   /** Adds a new entry at a specified position within this list.
       Entries originally at and above the specified position
       are at the next higher position within the list.
       The list's size is increased by 1.
       @param newPosition  An integer that specifies the desired
                           position of the new entry.
       @param newEntry     The object to be added as a new entry.
       @throws  IndexOutOfBoundsException if either
                newPosition < 1 or newPosition > getLength() + 1. */
   public void add(int newPosition, T newEntry);
   
   /** Removes the entry at a given position from this list.
       Entries originally at positions higher than the given
       position are at the next lower position within the list,
       and the list's size is decreased by 1.
       @param givenPosition  An integer that indicates the position of
                             the entry to be removed.
       @return  A reference to the removed entry.
       @throws  IndexOutOfBoundsException if either 
                givenPosition < 1 or givenPosition > getLength(). */
   public T remove(int givenPosition);
   
   /** Removes all entries from this list. */
   public void clear();
   
   /** Replaces the entry at a given position in this list.
       @param givenPosition  An integer that indicates the position of
                             the entry to be replaced.
       @param newEntry  The object that will replace the entry at the
                        position givenPosition.
       @return  The original entry that was replaced.
       @throws  IndexOutOfBoundsException if either
                givenPosition < 1 or givenPosition > getLength(). */
   public T replace(int givenPosition, T newEntry);
   
   /** Retrieves the entry at a given position in this list.
       @param givenPosition  An integer that indicates the position of
                             the desired entry.
       @return  A reference to the indicated entry.
       @throws  IndexOutOfBoundsException if either
                givenPosition < 1 or givenPosition > getLength(). */
   public T getEntry(int givenPosition);
   
   /** Retrieves all entries that are in this list in the order in which
       they occur in the list.
       @return  A newly allocated array of all the entries in the list.
                If the list is empty, the returned array is empty. */
   public T[] toArray();
   
   /** Sees whether this list contains a given entry.
       @param anEntry  The object that is the desired entry.
       @return  True if the list contains anEntry, or false if not. */
   public boolean contains(T anEntry);
   
   /** Gets the length of this list.
       @return  The integer number of entries currently in the list. */
   public int getLength();
       
   /** Sees whether this list is empty.
       @return  True if the list is empty, or false if not. */
   public boolean isEmpty();
} // end ListInterface

class aNode<T> {
    aNode(T data) {
        this.data = data;
        this.position = 0;
    }
    T data;
    aNode<T> next;
    aNode<T> prev;
    int position;
    static int lastPosition;
}

class LinkedListInterfacer implements ListInterface<String> {
    
    LinkedListInterfacer() {

    }
    public aNode<String> first = null;
    public aNode<String> last = null;

    public void add(String newEntry) {
        aNode<String> newNode = new aNode<String>(newEntry);
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        aNode.lastPosition++;
        newNode.position = aNode.lastPosition;
    }

    public void add(int newPosition, String newEntry) throws IndexOutOfBoundsException {
        aNode<String> newNode = new aNode<String>(newEntry);
        aNode<String> currNode = first;

        if (first != null && newPosition >= first.position && newPosition <= last.position) {
            //get node at position
            for (int i = 1; i < newPosition; i++) {
                currNode = currNode.next;
            }
            // assigning Nodes
            newNode.prev = currNode.prev;
            newNode.next = currNode;
            currNode.prev.next = newNode;
            currNode.prev = newNode;
            //assigning new positions
            newNode.position = currNode.position;
            while (currNode != null) {
                currNode.position++;
                currNode = currNode.next;
            }
            aNode.lastPosition++;
        }
        else {
            throw new IndexOutOfBoundsException("Given Position outside of scope");
        }
    }

    public String remove(int givenPosition) throws IndexOutOfBoundsException {
        aNode<String> currNode = first;
        String returnData;

        if (first != null && givenPosition >= first.position && givenPosition <= last.position) {
            //get node at position
            for (int i = 1; i < givenPosition; i++) {
                currNode = currNode.next;
            }
            returnData = currNode.data;
            // assigning Nodes
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            //assigning new positions
            currNode = currNode.next;
            while (currNode != null) {
                currNode.position--;
                currNode = currNode.next;
            }
            aNode.lastPosition--;
        }
        else {
            throw new IndexOutOfBoundsException("Given Position outside of scope");
        }

        return returnData;
    }

    public void clear() {
        // check if the node will deconstruct automatically
        aNode<String> currNode = first;
        first = null;
        last = null;
        while (currNode != null) {
            currNode.next = null;
            currNode = currNode.next;
            if (currNode != null) {
                currNode.prev = null;
            }
        }
        aNode.lastPosition = 0;
    }

    public String replace(int givenPosition, String newEntry) throws IndexOutOfBoundsException {
        aNode<String> currNode = first;
        String returnData = "Error No Data Found At givenPosition";
        if (first != null && givenPosition >= first.position && givenPosition <= last.position) {
            //get node at position
            for (int i = 1; i < givenPosition; i++) {
                currNode = currNode.next;
            }
            returnData = currNode.data;
            currNode.data = newEntry;
        }
        else {
            throw new IndexOutOfBoundsException("Given Position outside of scope");
        }
        return returnData;
    }

    public String getEntry(int givenPosition) {
        return "REPLACE";
    }

    public String[] toArray() {
        String[] returnArray = new String[aNode.lastPosition];
        aNode<String> currNode = first;
        for (int i = 0; i < aNode.lastPosition; i++) {
            returnArray[i] = currNode.data;
            currNode = currNode.next;
        }
        return returnArray ;
    }

    public boolean contains(String anEntry) {
        aNode<String> currNode = first;
        boolean isFound = false;
        for (int i = 0; i < aNode.lastPosition; i++) {
            if (currNode.data == anEntry) {
                isFound = true;
                break;
            }
            currNode = currNode.next;
        }
        return isFound;
    }

    public int getLength() {
        return aNode.lastPosition;
    }

    public boolean isEmpty() {
        return aNode.lastPosition > 0;
    }

    public static void main(String[] args) throws Exception {
        LinkedListInterfacer interfacedLL = new LinkedListInterfacer();
         
        interfacedLL.add("a");
        interfacedLL.add("b");
        interfacedLL.add("c");
        interfacedLL.add("d");
        interfacedLL.add(3, "e");
        System.out.println("return values: " + interfacedLL.remove(2));

        aNode<String> currNode = interfacedLL.first;
        for (int i = 0; i < aNode.lastPosition; i++) {
            System.out.println("currNode Position: " + currNode.position);
            System.out.println("currNode data: " + currNode.data);
            currNode = currNode.next;
            System.out.println("currNode next data: " + currNode);
        }
        String[] stringarr = interfacedLL.toArray();
        for (String string : stringarr) {
            System.out.println("stringarr: " + string);
        }
        System.out.println("data 'e' found: " + interfacedLL.contains("e"));
        System.out.println("data 'r' found: " + interfacedLL.contains("r"));


        System.out.println("aNode.lastPosition: " + aNode.lastPosition);

        interfacedLL.clear();
    }
}