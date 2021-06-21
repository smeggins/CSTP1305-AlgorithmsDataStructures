// Create a *List* ADT using an array data structure.

// ADT description:
// A list provides a way to organize data. We can have to-do lists, gift lists, address lists,
// grocery lists, even lists of lists. These lists provide a useful way for us to organize our
// lives, as illustrated in Figure 10-1. Each list has a first item, a last item, and usually
// items in between. That is, the items in a list have a position: first, second, and so on.
// An item’s position might be important to you, or it might not. When adding an item to
// your list, you might always add it at the end, or you might add it between two other
// items already in the list.

// ADT specifications:
// Everyday lists such as to-do lists, gift lists, address lists, and grocery lists have entries that are strings.
// What can you do to such lists?
// ###Typically, you add a new entry at the end of the list.
//### Actually, you can add a new entry anywhere: at the beginning, at the end, or in between items.
// ###You can erase an entry—that is, remove it.
// ###You can remove all entries.
// ###You can replace an entry.
// ###You can look at, or get, the entry at a given position.
// ###You can get all of the entries.
// ##You can find out whether the list contains a particular entry.
// ##You can count the number of entries in the list.
// ##You can see whether the list is empty.

// Also you can,

// ###Add a new entry to the beginning of this list.
// ###Add a new entry to the end of this list
// ###Remove and returns the first entry in this list.
// ###Remove and returns the last entry in this list. 
// ###Return the first entry in this list. 
// ###Return the last entry in this list. 
// Move the first entry in this list to the end of the list. 

public class Midterm {

    int[] arr  = new int[2];
    int lastIndex = -1;
    
    public void resize() {
        int[] newarr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }   
        arr = newarr;
    }

    // precondition: array can accomodate the new size
    // used in add(pos, val) and addstart(int val)
    public void shuffleAdd(int pos) {
        int tempA = 0;
        int tempB = 0;
        boolean firstItrComplete = false;
        for (int i = pos; i < lastIndex+2; i++) {
            if (firstItrComplete == false) {
                tempA = arr[i];
                tempB = arr[i];
                firstItrComplete = true;
            }
            else {
                tempA = arr[i];
                arr[i] = tempB;
                tempB = tempA;
            }
        }
    }

    public void add(int pos, int val) {
        if ((lastIndex + 1) == arr.length) {
            resize();
        }
        //if pos is in the array
        if (pos <= lastIndex) { 
            ++lastIndex;
            shuffleAdd(pos);
            arr[pos] = val;
        }
        else {
            addEnd(val); // increment last index in this method
        }

        
    }

    public void addEnd(int val) {
        if ((lastIndex + 1) == arr.length) {
            resize();
        }

        lastIndex++;
        arr[lastIndex] = val;
    }
    public void addStart(int val) {
        if ((lastIndex + 1) == arr.length) {
            resize();
        }
        lastIndex++;
        shuffleAdd(0);
        arr[0] = val;
    }

    public void remove(int pos) {
        for (int i = pos+1; i < lastIndex+1; i++) {
            arr[i-1] = arr[i];
        }
        lastIndex--;
    }

    public int removeReturnFirst() {
        int returnVal = arr[0];
        for (int i = 1; i < lastIndex+1; i++) {
            arr[i-1] = arr[i];
        }
        lastIndex--;
        return returnVal;
    }
    public int removeReturnLast() {
        int returnVal = arr[lastIndex];
        lastIndex--;
        return returnVal;
    }

    
    public void removeAll() {
        lastIndex = -1;
    }

    public void replace(int pos, int val) {
        if (pos <= lastIndex) {
            arr[pos] = val;
        }
        else {
            System.out.println("no item at this position");
        }
    }

    public int peek(int pos) {
        int returnval = -1;
        if (pos <= lastIndex) {
            returnval = arr[pos];
        }
        else {
            System.out.println("Position outside of array");
        }
        return returnval;
    }
    public int[] peek() {
        int[] returnarray = new int[lastIndex+1];
        if (lastIndex >= 0) {
            for (int i = 0; i < returnarray.length; i++) {
                returnarray[i] = arr[i];
            }
        }
        else {
            System.out.println("Array is empty!");
        }
        return returnarray;
    }

    // You can find out whether the list contains a particular entry.
    // to me the above comment asks for a boolean not an index position
    public boolean find(int val) {
        boolean found = false;
        for (int i = 0; i < lastIndex+1; i++) {
            if (arr[i] == val) {
                found = true;
                break;
            }
        }
        return found;
    }

    public int listSize() {
        return lastIndex+1;
    }
    
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    public void print(int[] anarr) {
        System.out.println("\n\nPrinting all values");
        for (int i = 0; i < anarr.length; i++) {
            System.out.println("arr val: " + anarr[i]);
        }
    }

    public int getFirst() {
        return arr[0];
    }

    public int getLast() {
        return arr[lastIndex];
    }

    public void moveFirstToLast() {
        int moveVal = removeReturnFirst();
        addEnd(moveVal);
    }


    public static void main(String[] args) throws Exception {
        System.out.println("midterm start: ");
        Midterm midterm = new Midterm();

        System.out.println("testing empty peek");
        midterm.peek();
        System.out.println("current list is empty: " + midterm.isEmpty());

        System.out.println("\n\nUsing addend to generate a list of values");
        midterm.addEnd(34);
        midterm.addEnd(11);
        midterm.addEnd(23);
        midterm.addEnd(9);
        midterm.addEnd(71);
        midterm.addEnd(56);
        midterm.addEnd(22);
        midterm.addEnd(4);

        System.out.println("Peeking pos 3: " + midterm.peek(3));

        int[] anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("\n\nAdding 42 to index 3");
        midterm.add(3, 42);

        anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("\n\nadding 99 to start pos");
        midterm.addStart(99);

        anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("\n\nremoving value at pos 5");
        midterm.remove(5);
        anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("\n\nremoving first value");
        midterm.removeReturnFirst();
        anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("\n\nremoving last value");
        midterm.removeReturnLast();
        anarr = midterm.peek();
        midterm.print(anarr);
        
        System.out.println("\n\nmoving first value to last value");
        midterm.moveFirstToLast();
        anarr = midterm.peek();
        midterm.print(anarr);

        System.out.println("item at position 3 before replace: " + midterm.arr[3]);
        midterm.replace(3, 888);
        System.out.println("item at position 3 after replace: " + midterm.arr[3]);

        System.out.println("Does the new item 888 exist in our array: " + midterm.find(888));

        System.out.println("current list size is: " + midterm.listSize());
        System.out.println("current list is empty: " + midterm.isEmpty());

        System.out.println("Code by Phillip Chadwick");
    }
}
