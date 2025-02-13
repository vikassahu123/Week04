//Word Frequency Counter
//        Read a text file and count the frequency of each word using a HashMap. Ignore case and punctuation.
//        Example:
//        Input: "Hello world, hello Java!" → Output: {hello=2, world=1, java=1}

package org.example.MapProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;

  public class MapFirst {
        public static void main(String[] args) {
            try {
                String path = "C:\\cap-4th week\\Day02\\src\\main\\java\\org\\example\\vikas.txt";
                FileReader fr= new FileReader(path);
                BufferedReader br=new BufferedReader(fr);
                String s;// s or line it is same.
                while((s=br.readLine())!=null){
                    HashMap<String,Integer>mp=new HashMap<>();
                    s= s.toLowerCase();
                    String []arr=s.split("[ ,!.]+");
                    for(String it:arr){
                        mp.put(it,mp.getOrDefault(it,0)+1);
                    }
                    System.out.println("frequency of words in given string is:"+mp);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());

            }

        }
    }
