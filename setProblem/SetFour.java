//Convert a Set to a Sorted List
//Convert a HashSet of integers into a sorted list in ascending order.
//Example:
//Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9].


package org.example.setProblem;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetFour {
    public static void main(String[] args) {

        Set<Integer> hashSet=new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        Set<Integer> treeset=new TreeSet<>(hashSet);// TreeSet is use for the printing asscending order of element.

        System.out.println(treeset);



    }
}
