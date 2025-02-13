//Merge Two Maps
//        Merge two maps such that if a key exists in both, sum their values.
//        Example:
//        Map1: {A=1, B=2}, Map2: {B=3, C=4} → Output: {A=1, B=5, C=4}.


package org.example.MapProblems;

import java.util.HashMap;

     public class MapForth {
        public static void main(String[] args) {
            HashMap<Character,Integer>mp2=new HashMap<>();
            HashMap<Character,Integer>mp=new HashMap<>();
            mp.put('A',10);
            mp.put('B',30);
            mp2.put('B',40);
            mp2.put('D',9);
            mp2.put('E',15);
            HashMap<Character,Integer>ansMp=new HashMap<>();
            for(Character it:mp.keySet()){
                if(mp2.containsKey(it)){
                    ansMp.put(it,mp.get(it)+mp2.get(it));
                }
                else{
                    ansMp.put(it,mp.get(it));
                }

            }
            for(Character it:mp2.keySet()){
                if(!mp.containsKey(it)){
                    ansMp.put(it,mp2.get(it));
                }
            }


            System.out.println("first map is: "+mp);
            System.out.println("second map is: "+mp2);
            System.out.println("merge map is: "+ansMp);

        }
    }
