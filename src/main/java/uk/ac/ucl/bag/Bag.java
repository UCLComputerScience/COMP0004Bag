package uk.ac.ucl.bag;

import java.util.Iterator;

/**
 * A Bag is a data structure that can hold a collection of values (really object references of course), along with
 * a count of how many copies of the value are in the collection.
 *
 * Each unique value is actually stored only once (i.e., there is only one object representing the value in the
 * data structure at any one time), along with a count of how many additional copies of the same
 * value have been added. The count is decremented when a value is removed. Values with a count of zero are no
 * longer stored.
 *
 * Bag extends the Iterable interface from the standard Java Class Library, meaning that a bag object provides an
 * iterator returning each value in the Bag in turn.
 *
 * @param <T> The type of the objects (values) stored in the Bag. The object must be an instance of a class that
 * implements the Comparable interface from the standard Java Class Library. This is what the syntax
 * <T extends Comparable> means, constraining the valid instantiations of T to a type that conforms to Comparable.
 * As a bag implementation requires object values to be compared, an object stored in a bag must support the
 * compareTo method defined by the Comparable interface.
 */
public interface Bag<T extends Comparable> extends Iterable<T>
{
  /**
   * The fixed maximum size of a bag.
   * This determines the maximum number of unique values that can
   * be stored in a bag, not the number of occurrences of each value.
   */
  static final int MAX_SIZE = 1000;

   /**
    * Add a value to a bag.
    * @param value The value to add.
    * @throws BagException If the bag is full.
    */
  void add(T value) throws BagException;

   /**
    * Add the given number of occurrences of value to a bag.
    * @param value The value to add.
    * @param occurrences The number of occurrences of the value.
    * @throws BagException If the bag is full.
    * Note that the bag holds a single copy of a given value, along with
    * the number of occurrences of that value. It does not store multiple
    * copies of the same value.
    */
  void addWithOccurrences(T value, int occurrences) throws BagException;

  /**
   * Check if the bag contains a value.
   * @param value The value to look for.
   * @return True if the bag contains the value, false otherwise.
   */
  boolean contains(T value);

  /**
   * Return the number of occurrences (count) of a value in the bag.
   * @param value The value to look for.
   * @return The number of occurrences.
   */
  int countOf(T value);

  /**
   * Remove an occurrence of value from the bag. If the last occurrence is removed,
   * remove the value as well. Do nothing if the value is not in the bag.
   * @param value The value to remove.
   */
  void remove(T value);

  /**
   * Determine the number of distinct values stored in the bag. The number of
   * occurrences of each value is not taken into account.
   * @return The number of distinct values in the bag.
   */
  int size();

  /**
   * Check if the set is empty.
   * @return True if the set is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * Create a new Bag containing the unique contents of this and the argument Bag, giving a bag containing all the
   * unique values each with a count of 1.
   * @param b The bag to add.
   * @return The new Bag.
   * @throws BagException If the bag becomes full while adding.
   */
  Bag<T> createMergedAllUnique(Bag<T> b) throws BagException;

  /**
   * Create a new Bag containing the contents of this and the argument Bag, with the counts of each value set to the
   * combined counts.
   * @param b The bag to add.
   * @return The new Bag.
   * @throws BagException If the bag becomes full while adding.
   */
  Bag<T> createMergedAllOccurrences(Bag<T> b) throws BagException;

  /**
   * Create an iterator that will iterate through every value and every occurrence of each value.
   * The default iterator method (declared by Iterator) will iterate through each value only without
   * returning each occurrence. This iterator will return the full set of values including all the copies.
   * @return The new Iterator.
   */
  public Iterator<T> allOccurrencesIterator();

  /*
  This method declaration is inherited from interface Iterator, so not redeclared here.
  Included here as a reminder that this method is part of the Bag interface.
  Return a standard iterator, giving each unique value in turn.
  public Iterator<T> iterator();
   */
}
