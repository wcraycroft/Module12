/* StudentTree.java - A binary tree which supports Strings of student names, able to calculate the height and diameter
 * Author:     Will Craycroft, Chris Merrill (altered version from textbook)
 * Module:     12
 * Project:    Lab12
 * Description: Modified version of demonstration with the added capability of calculating the height and diameter of the tree
 *
 *    Instance variables:
 *        root (StudentNode)
 *
 *    Static variables:
 *        theList - used to create String for toString()
 *
 *    Inner class StudentNode
 *        name (String)
 *        leftLink (StudentNode)
 *        rightLink (StudentNode)
 *
 *    Inner class StudentIterator
 *        getNextStudent
 *
 *    Methods:
 *        no-arg constructor
 *        getHeight() - returns the height of the tree (int)
 *        getDiameter() - returns the diameter of the tree (int)
 *        add(String name) -> insertInSubSubtree(name, root)
 *        contains(String name) -> isInSubtree(name, root)
 *        clear()
 */
public class StudentTree {

    private StudentNode root ;
    private static String theList ;

    // No-argument constructor creates an empty tree
    public StudentTree( ) {
        root = null ;
    }

    /**
     * Helper method that returns the height of the subTreeRoot
     * Lab questions:
     * Base case: when the iterator reaches the deepest leaf (null)
     * Number of call: It will call itself once for every node in the tree, descending both left and right branches.
     */
    private int getHeight(StudentNode subTreeRoot) {

        if (subTreeRoot == null) {
            return 0 ;
        }

        return 1 + Math.max(getHeight(subTreeRoot.leftLink),
                getHeight(subTreeRoot.rightLink)) ;
    }

    /**
     * Returns the diameter of a subTreeRoot, calculated recursively.
     */
    private int getDiameter(StudentNode subTreeRoot) {

        // If we are at a leaf, then we are done
        if (subTreeRoot == null) {
            return 0 ;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = getHeight(subTreeRoot.leftLink);
        int rightHeight = getHeight(subTreeRoot.rightLink);

        // Calculate the diameter of the left and right subtrees
        int leftDiameter = getDiameter(subTreeRoot.leftLink);
        int rightDiameter = getDiameter(subTreeRoot.rightLink) ;

        // Find the maximum of the leftsubtree diameter, the
        // rightsubtree subdiameter, and the longest path which
        // goes through the root
        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
    }

    // Returns the height of the subTreeRoot
    public int getHeight() {
        return getHeight(root) ;
    }

    // Returns the diameter of a subTreeRoot, calculated recursively.
    public int getDiameter() {
        return getDiameter(root) ;
    }

    // Adding a student to the tree invokes the recursive method insertInSubtree
    public void add(String studentName) {
        root = insertInSubtree(studentName, root) ;
    }

    // Returns true if the tree contains the student name
    public boolean contains(String studentName) {
        return isInSubtree(studentName, root) ;
    }

    // Clears the tree of all entries
    public void clear() {
        root = null ;
    }

   /*******************************************************************
    * Returns the root node of a tree that is the tree with root node
    * subTree, but with a new node added that contains item.
    *******************************************************************/
    private StudentNode insertInSubtree(String name, StudentNode subTree) {
        if (subTree == null) {
            return new StudentNode(name, null, null) ;
        } else if (name.compareTo(subTree.name) < 0) {
            subTree.leftLink = insertInSubtree(name, subTree.leftLink) ;
            return subTree ;
        } else { //item >= subTree.data
            subTree.rightLink = insertInSubtree(name, subTree.rightLink) ;
            return subTree ;
        }
    }

    private static boolean isInSubtree(String name, StudentNode subTree) {
        if (subTree == null) {
            return false ;
        } else if (subTree.name.equals(name)) {
            return true ;
        } else if (name.compareTo(subTree.name) < 0) {
            return isInSubtree(name, subTree.leftLink) ;
        } else {
            return isInSubtree(name, subTree.rightLink) ;
        }
    }

    // toString uses inOrder process
    public String toString() {
        theList = "" ;
        elementsInInOrder(root) ;
        return theList ;
    }

    // Processes elements in InOrder sequence and adds to "theList" variable
    private void elementsInInOrder(StudentNode subTree) {

        if (subTree != null) {
            elementsInInOrder(subTree.leftLink) ;
            theList += subTree.name + " " ;
            elementsInInOrder(subTree.rightLink) ;
        }
    }

    // Inner class for each node in the binary tree
    private class StudentNode {

        private String name ;
        private StudentNode leftLink ;
        private StudentNode rightLink ;

        public StudentNode(String studentName, StudentNode newLeftLink,
                                        StudentNode newRightLink) {
             name = studentName ;
             leftLink = newLeftLink ;
             rightLink = newRightLink ;
        }
    } // end of StudentNode class
}
