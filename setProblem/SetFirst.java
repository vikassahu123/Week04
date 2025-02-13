//Check if Two Sets Are Equal
//Compare two sets and determine if they contain the same elements, regardless of order.
//        Example:
//Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true.

package org.example.setProblem;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetFirst {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // We also write this above add elements like that
        // Collections.addAll(set1,1,2,3);


        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // We also write above add elements like that
        // Collections.addAll(set2,3,2,1);
        System.out.println(set1.equals(set2));




    }
}
