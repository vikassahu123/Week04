//Invert a Map
//        Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing them in a list.
//        Example:
//        Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}.


package org.example.MapProblems;

import java.util.ArrayList;
import java.util.HashMap;

    public class MapSecond {
        public static void main(String[] args) {
            HashMap<Character,Integer>mp=new HashMap<>();
            mp.put('A',1);
            mp.put('B',2);
            mp.put('C',1);
            mp.put('D',2);
            mp.put('E',3);
            HashMap<Integer, ArrayList<Character>>mp2=new HashMap<>();
            for(Character it:mp.keySet()){
                Character key=it;
                Integer val=mp.get(it);
                if(!mp2.containsKey(val)){
                    ArrayList<Character>arr=new ArrayList<>();
                    arr.add(key);
                    mp2.put(val,arr);
                }
                else{
                    mp2.get(val).add(key);
                }

            }
            System.out.println("initial array is: "+mp);
            System.out.println("inverted map is: "+mp2);


        }
    }
