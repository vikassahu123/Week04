//Reverse a List
//        Write a program to reverse the elements of a given List without using built-in reverse methods. Implement it for both ArrayList and LinkedList.
//        Example:
//        Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1].


package org.example.listProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;

public class ListFirst {


    public static void reversList(List<Integer> list)
    {
        int start=0;
        int end=list.size()-1; // size() is use in list.

        while(start<=end) {
            int temp = list.get(end); //  list.get(end)--> gives value at index ---> end index;
            int temp2 = list.get(start);  //list.get(start)--> gives value at index --> start index;

            list.set(end, temp2);
            list.set(start, temp);

            start++;
            end--;
        }
    }
    public static void main(String[] args) {

        List<Integer> arrayList=new ArrayList<>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(23);
        arrayList.add(24);

        System.out.println("Orignal list ");
        System.out.println(arrayList);

        System.out.println(" Reversed list ");
        reversList(arrayList);
        System.out.println(arrayList);

        LinkedList<Integer> linkedList=new LinkedList<>();

        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(23);
        linkedList.add(24);

        System.out.println("Orignal list ");
        System.out.println(linkedList);

        System.out.println(" Reversed list ");
        reversList(linkedList);         // reversed method is same for both ArrayList and linkedList.
        System.out.println(linkedList);




    }
}