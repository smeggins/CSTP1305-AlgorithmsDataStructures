import java.util.Iterator;
/**
   An interface that describes the operations of a set of objects.

*/
public interface SetInterface<T>
{
	/** Adds a new entry to this set, avoiding duplicates.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or
	             false if the item already is in the set. */
	public boolean add(T newEntry);

	/** Removes a specific entry from this set, if possible.
	    @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry);

   /** Removes one unspecified entry from this set, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
   public T remove();

   /** Tests whether this set contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if the set contains anEntry, or false if not. */
   public boolean contains(T anEntry);

 	/** Removes all entries from this set. */
	public void clear();

   /** Gets the current number of entries in this set.
       @return  The integer number of entries currently in the set. */
   public int getCurrentSize();

   /** Sees whether this set is empty.
       @return  True if the set is empty, or false if not. */
   public boolean isEmpty();

   /** Retrieves all entries that are in this set.
       @return  A newly allocated array of all the entries in the set. */
   public T[] toArray();

   /** Creates a new set that combines the contents of this set and another set.
       @param anotherSet  The second set.
       @return  A set that is the union of the two sets. */
   public SetInterface<T> union(SetInterface<T> anotherSet);

   /** Creates a new set that contains those items that occur
       in both this set and another set.
       @param anotherSet  The second set.
       @return  A set that is the intersection of the two sets. */
   public SetInterface<T> intersection(SetInterface<T> anotherSet);
} // end SetInterface
