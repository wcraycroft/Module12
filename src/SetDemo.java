/* SetDemo.java - Test the minus and equals methods of the modified Set class
 * Author:     Will Craycroft
 * Module:     12
 * Project:    Homework 12
 * Problem Statement: Determine the difference and equality of various sets of different data types
 *
 * Algorithm:
 *    1. Create 4 pairs of sets: letters, names, integers and integer/null
 *    2. For each pair of sets (A/B)
 *       Print both sets
 *       Print the result of A minus B
 *       Print the result of A intersects B
 *       Print the result of A union B
 *       Print the result of (A minus B) union (A intersects B) and the result of the equals method
 */

public class SetDemo {

    public static void main(String[] args) {

        /****************************
        **   Case 1: Letter sets   **
        *****************************/
        Set<String> lettersA = new Set<>() ;
        Set<String> lettersB = new Set<>() ;

        lettersA.add("C") ;
        lettersA.add("E") ;
        lettersA.add("G") ;
        lettersA.add("A") ;

        lettersB.add("E") ;
        lettersB.add("C") ;
        lettersB.add("F") ;
        // Test methods
        System.out.println("Letters set A:   " + lettersA) ;
        System.out.println("Letters set B:   " + lettersB) ;
        System.out.println("A - B:   " + lettersA.minus(lettersB)) ;
        System.out.println("A ∩ B:   " + lettersA.intersection(lettersB)) ;
        Set<String> minusUnionIntersection = lettersA.minus(lettersB).union(lettersA.intersection(lettersB));
        System.out.println("(A - B) U (A ∩ B):   " + minusUnionIntersection) ;
        System.out.println("Above set equals to A?:   " + minusUnionIntersection.equals(lettersA)) ;

        /****************************
         **   Case 2: Names sets   **
         *****************************/
        Set<String> namesA = new Set<>() ;
        Set<String> namesB = new Set<>() ;

        namesA.add("Carlos") ;
        namesA.add("John") ;
        namesA.add("Alica") ;

        namesB.add("John") ;
        namesB.add("Henry") ;
        namesB.add("Maria") ;
        // Test methods
        System.out.println("\nNames set A:   " + namesA) ;
        System.out.println("Names set B:   " + namesB) ;
        System.out.println("A - B:   " + namesA.minus(namesB)) ;
        System.out.println("A ∩ B:   " + namesA.intersection(namesB)) ;
        minusUnionIntersection = namesA.minus(namesB).union(namesA.intersection(namesB));
        System.out.println("(A - B) U (A ∩ B):   " + minusUnionIntersection) ;
        System.out.println("Above set equals to A?:   " + minusUnionIntersection.equals(namesA)) ;

        /****************************
        **   Case 3: Integer sets  **
        *****************************/
        Set<Integer> integersA = new Set<>() ;
        Set<Integer> integersB = new Set<>() ;

        integersA.add(5) ;
        integersA.add(1) ;
        integersA.add(3) ;

        integersB.add(1) ;
        integersB.add(3) ;
        integersB.add(5) ;
        integersB.add(7) ;
        integersB.add(9) ;
        // Test methods
        System.out.println("\nInteger set A:   " + integersA) ;
        System.out.println("Integer set B:   " + integersB) ;
        System.out.println("A - B:   " + integersA.minus(integersB)) ;
        System.out.println("A ∩ B:   " + integersA.intersection(integersB)) ;
        Set<Integer> intMinusUnionIntersection = integersA.minus(integersB).union(integersA.intersection(integersB));
        System.out.println("(A - B) U (A ∩ B):   " + intMinusUnionIntersection) ;
        System.out.println("Above set equals to A?:   " + intMinusUnionIntersection.equals(integersA)) ;

        /********************************
        **  Case 4: Integer/null sets  **
        *********************************/
        integersA = new Set<>() ;
        integersB = new Set<>() ;

        integersA.add(5) ;

        // Test methods
        System.out.println("\nInteger set A:   " + integersA) ;
        System.out.println("Integer set B:   " + integersB) ;
        System.out.println("A - B:   " + integersA.minus(integersB)) ;
        System.out.println("A ∩ B:   " + integersA.intersection(integersB)) ;
        intMinusUnionIntersection = integersA.minus(integersB).union(integersA.intersection(integersB));
        System.out.println("(A - B) U (A ∩ B):   " + intMinusUnionIntersection) ;
        System.out.println("Above set equals to A?:   " + intMinusUnionIntersection.equals(integersA)) ;

    }
}