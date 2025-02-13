//Find Subsets
//Check if one set is a subset of another.
//        Example:
//Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true.

package org.example.setProblem;

import java.util.HashSet;
import java.util.Set;

public class SetFive {
    public static void main(String[] args) {
        Set<Integer> hashSet1=new HashSet<>();
        hashSet1.add(2);
        hashSet1.add(3);

        Set<Integer> hashSet2 =new HashSet<>();
        hashSet2.add(1);
        hashSet2 .add(2);
        hashSet2 .add(3);
        hashSet2.add(4);

        Set<Integer> intersection =new HashSet<>(hashSet2); // get common ele and that all ele are same in the set1 so print yes.
        intersection.retainAll(hashSet1);

        if(intersection.equals(hashSet1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }


    }
}
