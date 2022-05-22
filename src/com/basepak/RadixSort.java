package com.basepak;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RadixSort {
    private static int count_range = 128;

    public static String[]  radixSort(String[] arr) {
        int max_length = 0;
        int operationCounter=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > max_length){
                max_length = arr[i].length();
            }
        }
        //the sorted array
        String[] sorted_arr = new String[arr.length];

        //comparing from the low digit to the highest digit
        for(int k = max_length-1;k >= 0;k--) {
            int[] counting = new int[count_range];
            for(int i = 0;i < arr.length;i++) {
                int index = get_char_indexNum(arr[i],k);
                counting[index]++;
                operationCounter=operationCounter+1;
            }
            //change the counter array elements
            int sum = 0;
            for(int i = 0;i < counting.length;i++) {
                sum += counting[i];
                counting[i] = sum;
            }
            //traverse the original array in reverse order and sort it.
            for(int i = arr.length-1;i >= 0;i--) {
                int index = get_char_indexNum(arr[i],k);
                sorted_arr[counting[index]-1] = arr[i];
                counting[index]--;
                operationCounter=operationCounter+1;
            }
            //copy each round result to arr.
            arr = sorted_arr.clone();
        }
        for(String str:arr) {
            System.out.println(str);
        }
        System.out.println("\nNumber of primitive operations done: "+operationCounter);
        return arr;
    }
    //Get the ascii code  of k th character of the string the ascii code
    private static int get_char_indexNum(String str, int k){
        //where the number of w digits is insufficient, add the 0 to the position
        if(str.length() < k+1){
            return 0;
        }
        return str.charAt(k);
    }

    public static void main(String[] args) throws IOException {
        String[] lines = Files.readAllLines(new File("src/com/basepak/clean_wordList.txt").toPath()).toArray(new String[0]);
        radixSort(lines);
    }
}
