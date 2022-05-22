package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {
    static long counter = 0;

    public static void main(String[] args) throws IOException {
        InsertionSort sorter = new InsertionSort(); // Creating an instance of a method to call
        File file = new File("src/com/basepak/clean_wordList.txt"); // Navigate the text file

        String[] str_list = new String[0]; // initializing str_list to store the string to array
        try {
            Scanner myReader = new Scanner(file); // to scan the content of the file to be read
            List<String> list = new ArrayList<String>();
            while (myReader.hasNext()) {
                // while myReader detect any next line it will add that line
                list.add(myReader.next());
            }
            int length = list.size(); // initialize length size

            str_list = new String[length];
            str_list = list.toArray(str_list);

            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sorter.insertionSortAscending(str_list, str_list.length);

            for (String x : str_list) {
                System.out.println(x);
            }
            System.out.println("Total primitive operations: "+counter);
        }
    }

    public static String[] insertionSortAscending(String[] array, int a) {
        String temp = "";
        int i = 0, j = 0;
        for (i = 0; i < a; i++){
            for (j = i + 1; j < a; j++) {

                if (array[i].compareToIgnoreCase(array[j]) > 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            counter+=j;
            System.out.println(i+" : "+counter);
        }
        return array;
    }

}
