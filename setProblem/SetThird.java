//Symmetric Difference
//Find the symmetric difference (elements present in either set but not in both) of two sets.
//Example:
//Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}.

package org.example.setProblem;

import java.util.HashSet;
import java.util.Set;

public class SetThird {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);


        // hashSet is used for storing unique element in the hashset.

        Set<Integer> unioun=new HashSet<>(set1);// copy of set1
        unioun.addAll(set2); // add all element of set2 in the unioun. [1,2,3,4,5]

        Set<Integer> intersection =new HashSet<>(set1); // copy of set1
        intersection.retainAll(set2); // retain all which is present on set2 also.[3]

        Set<Integer> SymmetricDifference=new HashSet<>(unioun);
        SymmetricDifference.removeAll(intersection); // remove all element --> which is present in the intersection from unioun.

        System.out.println("Symmetric Difference of two sets are : "+SymmetricDifference);
    }
}
