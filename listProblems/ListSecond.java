//Find Frequency of Elements
//Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
//        Example:
//Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}.
//

package org.example.listProblems;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListSecond {


    public static void main(String[] args) {
        List<String > list=new ArrayList<>();

        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        HashMap<String,Integer>mp=new HashMap<>();
        for(String it:list){
            mp.put(it,mp.getOrDefault(it,0)+1);
        }
        System.out.println(mp);




    }
}
