//Find the Nth Element from the End
//Given a singly linked list (use LinkedList), find the Nth element from the end without calculating its size.
//Example:
//Input: [A, B, C, D, E], N=2 → Output: D.

package org.example.listProblems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListFive {
    public static void main(String[] args) {
       List<Character> single=new LinkedList<>();
        int n=2;// n th term from last.

       single.add('A');
       single.add('B');
       single.add('C');
       single.add('D');
       single.add('E');

        Collections.reverse(single);  // E,D,C,B,A

        System.out.println(single.get(n-1)); // 2-1 because at 1 index D is present and all index start from 0;

    }
}
