//Union and Intersection of Two Sets
//Given two sets, compute their union and intersection.
//        Example:
//Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}.

package org.example.setProblem;

import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

public class SetSecond {
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
        unioun.addAll(set2); // add all element of set2 in the unioun.

        Set<Integer> intersection =new HashSet<>(set1); // copy of set1
        intersection.retainAll(set2); // retain all which is present on set2 also.

        System.out.println("unioun of set is : "+ unioun);
        System.out.println("intersection of set is : "+intersection);








    }
}
