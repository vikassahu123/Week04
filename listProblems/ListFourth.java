//Remove Duplicates While Preserving Order
//Remove duplicate elements from a list while maintaining the original order of elements.
//Example:
//Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4].

package org.example.listProblems;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ListFourth {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2=new ArrayList<>();
        for(int ele=0;ele<list1.size();ele++) {

            if (!list2.contains(list1.get(ele))) {
                list2.add(list1.get(ele));
            }
        }

        System.out.println(list2);


    }
}
