package uk.ac.ucl.bag;

import java.util.Iterator;

/**
 * Example code illustrating the use of Bag objects.
 */
public class Main
{
  private BagFactory<String> factory = BagFactory.getInstance();

  public void print(Bag<String> bag)
  {
    boolean first = true;
    System.out.print("{");
    for (String value : bag)
    {
      if (!first) { System.out.print(" , "); }
      first = false;
      System.out.print(value);
    }
    System.out.println("}");
  }

  public void printAll(Bag<String> bag)
  {
    boolean first = true;
    System.out.print("{");
    Iterator<String> allIterator = bag.allOccurrencesIterator();
    while (allIterator.hasNext())
    {
      if (!first) { System.out.print(" , "); }
      first = false;
      System.out.print(allIterator.next());
    }
    System.out.println("}");
  }

  public void go()
  {
    factory.setBagClass("ArrayBag");

    try
    {
      Bag<String> bag1;
      Bag<String> bag2;
      Bag<String> bag3;

      bag1 = factory.getBag();
      bag1.add("abc");
      bag1.add("def");
      bag1.add("hij");
      System.out.print("bag1 all unique:             ");
      print(bag1);
      System.out.print("bag1 all:                    ");
      printAll(bag1);

      bag2 = factory.getBag();
      bag2.add("def");
      bag2.add("def");
      bag2.add("def");
      bag2.add("klm");
      System.out.print("bag2 all unique:             ");
      print(bag2);
      System.out.print("bag2 all:                    ");
      printAll(bag2);

      bag3 = factory.getBag();
      bag3.addWithOccurrences("xyz", 5);
      bag3.add("opq");
      bag3.addWithOccurrences("123", 3);
      System.out.print("bag3 all unique:             ");
      print(bag3);
      System.out.print("bag3 all:                    ");
      printAll(bag3);


      System.out.print("createMergedAllOccurrences:  ");
      Bag<String> bag4 = bag1.createMergedAllOccurrences(bag3);
      printAll(bag4);

      System.out.print("createMergedAllUnique:       ");
      Bag<String> bag5 = bag1.createMergedAllUnique(bag3);
      print(bag5);
    }
    catch (BagException e)
    {
      System.out.println("====> Bag Exception thrown...");
    }
  }

  public static void main(String[] args)
  {
    new Main().go();
  }
}