package com.basepak;

import java.nio.file.Files;
import java.io.*;


public class BubbleSort {
    private static long counter = 0;

    public static int compare(String s1, String s2) {
        //return 1, s1 > s2
        //returns -1, s1 < s2
        //returns 0, s1 == s2
        int i = 0;

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
            else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
            i++;
        }
            return 1;

    }
    public static String[] bubble_sort(String[] arr) {
        counter+=2; //counts for initializing i and j;
        for(int i=0; i < arr.length; i++) {
            counter+=3; //counts for the comparison and implementation of i.
            for (int j = 0; j < arr.length - 1; j++) {
                counter+=3; //counts for the comparison and implementation of j.
                counter+=3; //counts for condition lines[j] and lines[j+1], and the method of compareTo
                if (compare(arr[j],arr[j+1]) > 0) {
                    String temp = arr[j];
                    counter+=2; //counts for the implementation of temp and lines[j].
                    arr[j] = arr[j + 1];
                    counter+=3; //counts for the implementation of lines[j+1] and lines[j].
                    arr[j + 1] = temp;
                    counter+=2; //counts for the implementation of temp and lines[j+1].
                }
            }
        }
        counter++;//count for return statement
        return arr;
    }

    public static void main(String[] args) throws IOException {

        //read file to string array
        String[] lines = Files.readAllLines(new File("src/com/basepak/clean_wordList.txt").toPath()).toArray(new String[0]);
        //bubble sort in lexicographical order
        bubble_sort(lines);
        for (String x : lines) {
            System.out.println(x);
        }
        //print out Bubble Sort Primitive Operations counter
        System.out.println("Bubble Sort Primitive Operations count: "+counter);
    }
}
