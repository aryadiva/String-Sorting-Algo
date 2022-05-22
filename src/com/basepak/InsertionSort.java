package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.CharSequence.compare;

public class InsertionSort {
    static long counter = 0;

    public static void main(String[] args) throws IOException {
        InsertionSort sorter = new InsertionSort(); // Creating an instance of a method to call
        File file = new File("src/com/basepak/clean_wordList.txt"); // Navigate the text file to be read

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
            // calling insertionsort method
            sorter.insertionSort(str_list, str_list.length);// calling the insertionSort function

            // displaying the sorted list
            for (String x : str_list) {
                System.out.println(x);
            }
            System.out.println("Insertion Sort Primitive Operations count: " + counter);
        }
    }

    public static String[] insertionSort(String[] array, int length) {
        counter++;
        for (int i = 1; i < length; i++) {
            counter += 2;//count for the for loop condition
            String key = array[i]; //store the element in the key
            counter++; //count for the assign value
            int j = i - 1;
            counter++;//count for the assign value
            while (j >= 0 && compare(key, array[j]) < 0) { //compare the element in the key and the element in the sorted array
                //if element is smaller than current one, move it to the next.
                array[j + 1] = array[j];
                j--;
                counter += 3;//count for the assign value and decrement
            }
            array[j + 1] = key;
            counter += 2;//count for the assign value
        }
        return array;
    }
}



