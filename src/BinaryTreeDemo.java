/* BinaryTreeDemo.java - Modified version of in class demo by Chris Merrill
 * Author:     Will Craycroft
 * Module:     12
 * Project:    Lab 12
 * Problem Statement: Create a binary tree of names, and test their heights and diameters.
 *
 * Algorithm:
 *   1. Create tree 1 with names entered in alphabetical order, print tree, height and diameter
 *   2. Create tree 2 with names entered in reverse alphabetical order, print tree, height and diameter
 *   3. Create tree 3 with names entered to match the Lab diagram.
 *   4. Create tree 4 with 13 name, diameter of 9, height 6 which matches the shape in lab diagram
 *   5. Create tree 5 with 15 name, diameter of 9, height 6 which matches the shape in lab diagram
 *
 */


public class BinaryTreeDemo {

    public static void main(String[] args) {

        // Create an empty tree
        StudentTree tree = new StudentTree( ) ;

        // Tree 1: Entered in alphabetical order
        tree.add("Albert") ;
        tree.add("Barbara") ;
        tree.add("Charlie") ;
        tree.add("Dexter") ;
        tree.add("Eduardo") ;
        tree.add("Frank") ;
        tree.add("Georgio") ;
        tree.add("Henrietta") ;
        System.out.println("Adding  Albert, Barbara, Charlie, Dexter, Eduardo, Frank, Georgio, Henrietta:") ;
        System.out.println("   The list: " + tree) ;
        System.out.println("   Height: " + tree.getHeight()) ;
        System.out.println("   Diameter: " + tree.getDiameter()) ;

        tree.clear();
        // Tree 2: Entered in reverse alphabetical order
        tree.add("Henrietta") ;
        tree.add("Georgio") ;
        tree.add("Frank") ;
        tree.add("Eduardo") ;
        tree.add("Dexter") ;
        tree.add("Charlie") ;
        tree.add("Barbara") ;
        tree.add("Albert") ;
        System.out.println("\nAdding  Henrietta, Georgio, Frank, Eduardo, Dexter, Charlie, Barbara, Albert:") ;
        System.out.println("   The list: " + tree) ;
        System.out.println("   Height: " + tree.getHeight()) ;
        System.out.println("   Diameter: " + tree.getDiameter()) ;

        tree.clear();
        // Tree 3: Entered inorder sequence
        tree.add("Charlie") ;
        tree.add("Barbara") ;
        tree.add("Albert") ;
        tree.add("Eduardo") ;
        tree.add("Dexter") ;
        tree.add("Georgio") ;
        tree.add("Frank") ;
        tree.add("Henrietta") ;
        System.out.println("\nAdding  Charlie, Barbara, Albert, Eduardo, Dexter, Georgio, Frank, Henrietta:") ;
        System.out.println("   The list: " + tree) ;
        System.out.println("   Height: " + tree.getHeight()) ;
        System.out.println("   Diameter: " + tree.getDiameter()) ;

        tree.clear();
        // Tree 4: Diameter 9, through root (13 nodes total)
        // Root
        tree.add("Frank") ;
        // Left subtree
        tree.add("Barbara") ;
        tree.add("Albert") ;
        tree.add("Dexter") ;
        tree.add("Charlie") ;
        tree.add("Eduardo") ;
        // Right subtree
        tree.add("Georgio") ;
        tree.add("Henrietta") ;
        tree.add("Lisa") ;
        tree.add("Jeff") ;
        tree.add("Izzy") ;
        tree.add("Kendra") ;
        tree.add("Mark") ;

        System.out.println("Frank, Barbara, Albert, Dexter, Charlie, Eduardo, Georgio, Henrietta, Lisa, Jeff, Izzy, Kendra, Mark:") ;
        System.out.println("   The list: " + tree) ;
        System.out.println("   Height: " + tree.getHeight()) ;
        System.out.println("   Diameter: " + tree.getDiameter()) ;

        tree.clear();
        // Tree 5: Diameter 9, not through root (15 nodes total)
        // Root
        tree.add("Mark") ;
        // Right subtree
        tree.add("Noah") ;
        tree.add("Oliver") ;

        // Left subtree
        // Left subroot
        tree.add("Georgio") ;
        // Left-left subtree
        tree.add("Barbara") ;
        tree.add("Albert") ;
        tree.add("Frank") ;
        tree.add("Dexter") ;
        tree.add("Charlie") ;
        tree.add("Eduardo") ;
        // Left-right subtree
        tree.add("Henrietta") ;
        tree.add("Jeff") ;
        tree.add("Izzy") ;
        tree.add("Kendra") ;
        tree.add("Lisa") ;

        System.out.println("Mark, Noah, Oliver, Georgio, Barbara, Albert, Frank, Dexter, Charlie, Eduardo, Henrietta, Jeff, Izzy, Kendra, Lisa:") ;
        System.out.println("   The list: " + tree) ;
        System.out.println("   Height: " + tree.getHeight()) ;
        System.out.println("   Diameter: " + tree.getDiameter()) ;

    }
}
