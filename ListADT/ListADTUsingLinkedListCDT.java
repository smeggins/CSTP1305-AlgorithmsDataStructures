




//****************************************************************************************
/////////////////////////////////////////////////////////////////////////////////////////*
//////See listInterface under assingments for my implementation which i like better//////*
/////////////////////////////////////////////////////////////////////////////////////////*
//****************************************************************************************





class ListNode{
    String data;
    ListNode next;

}
public class ListADTUsingLinkedListCDT {
    ListNode first;
    ListNode last;

    ListADTUsingLinkedListCDT(){
        first = null;
        last = null;
    }
    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list's size is increased by 1.
     @param newEntry  The object to be added as a new entry. */
    public void add(String newEntry){
        ListNode aNewNode = new ListNode();
        aNewNode.data = newEntry;

        if(last == null){
            // the list is empty
            last = aNewNode;
            first = aNewNode;
        }else {
            // the list is not empty
            last.next = aNewNode;
            last = aNewNode;
        }
    }

    /** Adds a new entry at a specified position within this list.
     Entries originally at and above the specified position
     are at the next higher position within the list.
     The list's size is increased by 1.
     @param newPosition  An integer that specifies the desired
     position of the new entry.
     @param newEntry     The object to be added as a new entry.
     @throws  IndexOutOfBoundsException if either
     newPosition < 1 or newPosition > getLength() + 1. */
    public void add(int newPosition, String newEntry) {
        // step 1 - create the new node
        ListNode aNewNode = new ListNode();
        aNewNode.data = newEntry;

        // step 2 - check if the list is empty
        if(first == null){
            first = aNewNode;
            last = aNewNode;
        }else if (newPosition == 1){
            // step 3 - deal with the special case in which you  want to insert at position number 1
            aNewNode.next = first;
            first = aNewNode;
        } else {
            // the normal case
            ListNode before = returnsBefore(newPosition);
            aNewNode.next = before.next;
            before.next = aNewNode;
        }

    }


    /**
     * Assume position > 1
      @param position is basically any position
      @return return the node in the list with a position equal to @param position -1
     */
    ListNode returnsBefore(int position){
        ListNode result = new ListNode();
        int starting_position = 1;
        result = first;

        while(starting_position != (position - 1) ){
            result = result.next;
            starting_position++;
        }
        return result;
    }

    /** Removes the entry at a given position from this list.
     Entries originally at positions higher than the given
     position are at the next lower position within the list,
     and the list's size is decreased by 1.
     @param givenPosition  An integer that indicates the position of
     the entry to be removed.
     @return  A reference to the removed entry.
     @throws  IndexOutOfBoundsException if either
     givenPosition < 1 or givenPosition > getLength(). */
    public String remove(int givenPosition){
        if(first == last && first !=null){
            //there is only on element in the list
            String result = first.data;
            first = null;
            last = null;
            return result;
        }else{
            int i = 1;
            ListNode iterator = first;
            while ( i < givenPosition){
                iterator = iterator.next;
                i++;
            }
            String result = iterator.data;
            ListNode before = returnsBefore(givenPosition);
            before.next = before.next.next;

            // check whether you have to change the last pointer
            if(before.next == null ){
                last = before;
            }
            return result;
        }
    }
//
//    /** Removes all entries from this list. */
//    public void clear();
//
//    /** Replaces the entry at a given position in this list.
//     @param givenPosition  An integer that indicates the position of
//     the entry to be replaced.
//     @param newEntry  The object that will replace the entry at the
//     position givenPosition.
//     @return  The original entry that was replaced.
//     @throws  IndexOutOfBoundsException if either
//     givenPosition < 1 or givenPosition > getLength(). */
//    public String replace(int givenPosition, String newEntry);
//
//    /** Retrieves the entry at a given position in this list.
//     @param givenPosition  An integer that indicates the position of
//     the desired entry.
//     @return  A reference to the indicated entry.
//     @throws  IndexOutOfBoundsException if either
//     givenPosition < 1 or givenPosition > getLength(). */
//    public String getEntry(int givenPosition);
//
//    /** Retrieves all entries that are in this list in the order in which
//     they occur in the list.
//     @return  A newly allocated array of all the entries in the list.
//     If the list is empty, the returned array is empty. */
//    public String[] toArray();
//
//    /** Sees whether this list contains a given entry.
//     @param anEntry  The object that is the desired entry.
//     @return  True if the list contains anEntry, or false if not. */
//    public boolean contains(String anEntry);
//
//    /** Gets the length of this list.
//     @return  The integer number of entries currently in the list. */
//    public int getLength();
//
//    /** Sees whether this list is empty.
//     @return  True if the list is empty, or false if not. */
//    public boolean isEmpty();


    public static void main(String[] args) {
        ListADTUsingLinkedListCDT aList = new ListADTUsingLinkedListCDT();
        aList.add("read chapter 10");
        aList.add("call home");
        aList.add("buy card for sue");

        aList.add(2, "call Phillip");
        // The list at this point of time should have these items
        //        1- ("read chapter 10");
        //        2- ("call Phillip");
        //        3- ("call home");
        //        4- ("buy card for sue");



        System.out.println(aList.remove(3)); // should print "call home"
        // The list at this point of time should have these items
        //        1- ("read chapter 10");
        //        2- ("call Phillip");
        //        4- ("buy card for sue");




        //        aList.replace(2, "send an email");
//        // The list at this point of time should have these items
//        //        1- ("read chapter 10");
//        //        2- ("send an email");
//        //        3- ("buy card for sue");
//        aList.replace(2);
//        // The list at this point of time should have these items
//        //        1- ("read chapter 10");
//        //        3- ("buy card for sue");
    }
}