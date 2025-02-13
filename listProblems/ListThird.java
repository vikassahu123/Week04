//Rotate Elements in a List
//Rotate the elements of a list by a given number of positions.
//Example:
//Input: [10, 20, 30, 40, 50], rotate by 3 → Output: [30, 40, 50, 10, 20].

package org.example.listProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListThird {
    public static void rorateList(List<Integer> list,int k)
    {


        // if k=3;
        Collections.reverse(list); // 50,40,30,20,10
        Collections.reverse(list.subList(0,k)); // 30,40,50  because give < k
        Collections.reverse(list.subList(k,list.size())); // it is go from k=3 index which is on 20 than rotate it.
    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int rotatedBy=3;
        rorateList(list,rotatedBy);
        System.out.println(list);



    }
}
