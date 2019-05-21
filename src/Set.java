/* Set.java - Modified version of the Set class in the textbook
 * Author:     Will Craycroft, Textbook
 * Module:     12
 * Project:    Homework 12
 * Description:  This is a modified version of the textbook Set class which has the added functionality of determining
 *  the difference between 2 sets (minus) and the equality of two sets
 *
 *    Instance variables:
 *         head
 *
 *    Inner class
 *         Node
 *
 *    Methods:
 *        no-argument constructor
 *        add (T)
 *        contains(T)
 *        minus() - returns the difference between two sets
 *        equals() - returns true if both sets contain the same elements
 *        intersection(Set<T>)
 *        union(Set<T>)
 *        toString()
 */
 public class Set<T> {

    private Node<T> head ; // instance variable
    public Set() {
        head = null ;
    }

   /***********************************************************************
    * Add a new item to the set.  If the item is already in the set, false
    * is returned, otherwise true is returned.
    ***********************************************************************/
    public boolean add(T newItem) {
        if (!contains(newItem)) {
            head = new Node<T>(newItem, head);
            return true;
        }
        return false;
    }

   /**************************************
    * Returns true if an item is in list
    **************************************/
    public boolean contains(T item) {
        Node<T> position = head ;
        T itemAtPosition ;
        while (position != null) {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(item))
                return true ;
            position = position.link ;
        }
        return false ; // not found
    }

    /**************************************************************************
     * Returns the difference between this set and the set passed as a parameter,
     * as a Set containing all elements in the set that are not present in otherSet
     **************************************************************************/
    public Set<T> minus(Set<T> otherSet)  {

        // Create a new set
        Set<T> minusSet = new Set<T>() ;
        Node<T> position = head;

        // Add an element into the new set only if it does not exit in otherSet
        while (position != null) {
            if (!otherSet.contains(position.data))
                minusSet.add(position.data) ;
            position = position.link ;
        }
        return minusSet ;
    }

    /**************************************************************************
     * Returns true if this set contains all elements in the passed set, and vice versa
     **************************************************************************/
    public boolean equals(Set<T> otherSet)  {

        Node<T> position = head;

        // Iterate through this set, checking if all elements exist in other set
        while (position != null) {
            if (!otherSet.contains(position.data))
                return false ;
            position = position.link ;
        }

        position = otherSet.head;

        // Iterate through other set, checking if all elements exist in this set
        while (position != null) {
            if (!this.contains(position.data))
                return false ;
            position = position.link ;
        }
        return true ;
    }

   /**************************************************************************
    * Returns the intersection of this set with the set passed as a parameter
    * Note: an item is in the intersection of sets A and B iff it is in both
    * sets A and B
    **************************************************************************/
    public Set<T> intersection(Set<T> otherSet)  {

       // Create a new set
       Set<T> intersectionSet = new Set<T>() ;
       Node<T> position = head;

       // Add an element into the new set only if it is in both this set and
       // in the otherSet.
       while (position != null) {
           if (otherSet.contains(position.data))
                 intersectionSet.add(position.data) ;
           position = position.link ;
       }
       return intersectionSet ;
    }

   /**************************************************************************
    * Returns the union of this set with the set passed as a parameter
    * Note: an item is in the union of sets A and B iff it is in set A, in
    * set B, or in both sets A and B
    **************************************************************************/
    public Set<T> union(Set<T> otherSet) {

        // Create a new set
        Set<T> unionSet = new Set<T>() ;
        Node<T> position = head ;

        // Add the contents of this set into the new set
        while (position != null) {
            unionSet.add(position.data) ;
            position = position.link ;
        }

        // Add the elements of the "otherSet", avoid duplicates
        position = otherSet.head ;
        while (position != null) {
            unionSet.add(position.data) ;
            position = position.link ;
        }
        return unionSet ;
    }

   /**********************************************************************
    * toString returns a list of all of the elements in the set (changed
    * from the output method in textbook.
    **********************************************************************/
    public String toString() {

        // Traverse the list each nodes adding the contents of each
        // node to a String
        String returnString = "" ;

        Node position = head;
        while (position != null) {
            returnString += (position.data.toString() + " ");
            position = position.link;
        }
        return returnString ;
    }

   /****************************************************************
    * Inner class (private) which contains a data element of type T,
    * and a link to the next node in the (linked list) set
    ****************************************************************/
    private class Node<T> {

        // Instance variables
        private T data ;
        private Node<T> link ;

        // No-arg and full constructors
        public Node( ) {
            data = null ;
            link = null ;
        }
        public Node(T newData, Node<T> linkValue) {
            data = newData ;
            link = linkValue ;
        }
    }
}