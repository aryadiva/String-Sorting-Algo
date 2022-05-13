package com.basepak;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFileIntoStrings {
    public static void main(String[] args){
        File file = new File("src/com/basepak/practice.txt");
        try{
            Scanner myReader = new Scanner(file);
            List<String> list = new ArrayList<String>();

            while(myReader.hasNext()){
                list.add(myReader.next());
                //System.out.println(data);
            }
            //System.out.println(list);
            //System.out.println(list.get(1));
            int length = list.size();

            String[] str_list = new String[length];
            str_list = list.toArray(str_list);

            for(String x : str_list){
                System.out.println(x+",");
            }

            //System.out.println(length);

            /*
            ArrayList<Character>[] chars = new ArrayList[length];
            for(int i = 0; i < length; i++){
                chars[i] = new ArrayList<Character>();
            }
            //ArrayList<Character> chars = new ArrayList<>();

            System.out.println(chars);

            for(int i = 0; i < length; i++){
                for(char ch: list.get(i).toCharArray()){
                    chars[i].add(ch);
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < chars[i].size(); j++) {
                    System.out.print(chars[i].get(j) + " ");
                }
                System.out.println();
            }
            if(chars[0].get(0) < chars[1].get(0)){
                System.out.println("Smaller");
            }
            else if(chars[0].get(0) > chars[1].get(0)){
                System.out.println("Bigger");
            }
             */

            myReader.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
