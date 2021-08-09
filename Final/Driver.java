import java.util.Iterator;
/**
   A driver that demonstrates the class DictionarySet.
 */
public class Driver
{
	public static void main(String args[])
	{
		SetInterface<Integer> test1 = new DictionarySet();

		test1.add(1);
		test1.add(3);
		test1.add(2);
		test1.add(0);
		test1.add(-1);

		System.out.print("The set has ");
		displaySet(test1);
		System.out.println();

		System.out.println("Contains for -1 yields " + test1.contains(-1));
		System.out.println("Contains for -2 yields " + test1.contains(-2));
		System.out.println("Contains for 3 yields " + test1.contains(3));
		System.out.println("Contains for 4 yields " + test1.contains(4));

		test1.add(1);
		System.out.println("Added 1 again to the set, should be the same");
		displaySet(test1);
		System.out.println();


		test1.remove(-1);
		test1.remove(20);
		test1.remove(3);

		System.out.println("Should just have 0 1 and 2 now");
		displaySet(test1);
		System.out.println();

		System.out.println("Create a second set");

		SetInterface<Integer> test2 = new DictionarySet();

		test2.add(1);
		test2.add(3);
		test2.add(2);
		test2.add(-1);
		test2.add(5);
		test2.add(8);

		System.out.print("The second set has ");
		displaySet(test2);
		System.out.println();

		System.out.print("The union contains ");
		SetInterface<Integer> testUnion = test1.union(test2);
		displaySet(testUnion);
		System.out.println();

		System.out.println("The first set should be unchanged; it contains ");
		displaySet(test1);
		System.out.println();

		System.out.println("The second set should be unchanged; it contains ");
		displaySet(test2);
		System.out.println();
		System.out.print("The intersection contains ");
		SetInterface<Integer> testIntersection = test2.intersection(test1);
		displaySet(testIntersection);
		System.out.println();

		System.out.println("The first set should be unchanged; it contains ");
		displaySet(test1);
		System.out.println();

		System.out.println("The second set should be unchanged; it contains ");
		displaySet(test2);
		System.out.println();

      System.out.println("Remove an entry from the second set ");
      Integer anEntry = test2.remove();
      System.out.println("Removed " + anEntry);
      System.out.println("The set contains ");
      displaySet(test2);
	} // end main

	private static void displaySet(SetInterface<Integer> aSet)
	{
		System.out.println(aSet.getCurrentSize() + " item(s), as follows:");
		Object[] setArray = aSet.toArray();

		for (int index = 0; index < setArray.length; index++)
			System.out.print(setArray[index] + " ");

		System.out.println();
	} // end displaySet
}  // end Driver

/*
 The set has 5 item(s), as follows:
 1 3 2 0 -1

 Contains for -1 yields true
 Contains for -2 yields false
 Contains for 3 yields true
 Contains for 4 yields false
 Added 1 again to the set, should be the same
 5 item(s), as follows:
 1 3 2 0 -1

 Iterating over the set
 1
 3
 2
 0
 -1
 Should just have 0 1 and 2 now
 3 item(s), as follows:
 1 2 0

 Create a second set
 The second set has 6 item(s), as follows:
 1 3 2 -1 5 8

 The union contains 7 item(s), as follows:
 1 2 0 3 -1 5 8

 The first set should be unchanged; it contains
 3 item(s), as follows:
 1 2 0

 The second set should be unchanged; it contains
 6 item(s), as follows:
 1 3 2 -1 5 8

 The intersection contains 2 item(s), as follows:
 1 2

 The first set should be unchanged; it contains
 3 item(s), as follows:
 1 2 0

 The second set should be unchanged; it contains
 6 item(s), as follows:
 1 3 2 -1 5 8

 Remove an entry from the second set
 Removed 1
 The set contains
 5 item(s), as follows:
 3 2 -1 5 8
 */
