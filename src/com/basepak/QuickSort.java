package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    static long counter = 0; // initialize counter for counting primitive operations

    public static void main(String[] args) throws IOException {
        QuickSort sorter = new QuickSort(); // Creating an instance of method to call

        File file = new File("src/com/basepak/clean_wordList.txt"); // Navigate the text file to be read
        File txt = new File("src/com/basepak/Quick-Sorted.txt"); // creating a new file to store the sorted words
        FileWriter writer = new FileWriter(txt); // To write to the newly created sorted file

        String[] str_list = new String[0]; // initializing str_list to store the string to array
        try {
            Scanner myReader = new Scanner(file); // to scan the content of the file to be read
            List<String> list = new ArrayList<String>(); // creating an instance of list
            while (myReader.hasNext()) {
                // while myReader detect any next line it will add that line to list
                list.add(myReader.next());
            }

            int length = list.size(); // initialize length size
            str_list = new String[length]; // creating a new array to store the sorted words
            str_list = list.toArray(str_list); // converting list to array

            myReader.close(); // closing myReader
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // calling the quicksort method
            sorter.quickSort(str_list, 0, str_list.length-1);

            // printing the sorted list
            for (String x : str_list) {
                System.out.println(x);
            }

            //-------To write the sorted result to external txt file
            for(int i = 0; i < str_list.length; i++){
                writer.write(str_list[i]+'\n'); // writing each element(i) in array to a new file
                if(i == str_list.length-1){
                    writer.write('\n'+"Total primitive operations: "+counter);
                }
            }
            writer.close();
            // to display the total primitive operations in Java IDE(Intellij)
            System.out.println("Total primitive operations: "+counter);
        }
    }

    public void quickSort(String[] array, int lowerIndex, int higherIndex) throws IOException {
        // calling this method counted as 1 operation
        // and passing 3 parameter counted as 3 operation
        counter+=4;

        counter+=2; // creating an if statement that accept either/both of the condition
        // if the array is null or has length of 0, return this method without doing anything
        if (array == null || array.length == 0) {
            counter+=1; // returning nothing count as 1 operation
            return;
        }

        int i = lowerIndex; // set i as the lower index
        int j = higherIndex; // set j as the high index
        counter+=4; // creating i & j and assigning both of them as integer count as 2 operation each

        /*----------------------------------------------------------
        String pivot = array[higherIndex];  // worst case
        String pivot = array[lowerIndex];   // worst case

        // average case for quicksort is referring twhen the array elements in the  list is in a random order
        // so average case has already been implemented and has the same time complexity as best case
         ---------------------------------------------------------*/

        // the pivot is based on the middle element of the whole array
        String pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2]; // Best case scenario

        // creating a string pivot from the array count as 2 operation
        // the operations choosing the element inside the array count as 3 operation
        counter+=5;

        counter+=2; // creating a while loop based on comparison condition between i & j count as 2 operation
        // while low index is smaller or equal than high index
        while (i <= j) {
            // while element i in array is lexicographically less than the pivot
            // i will keep incrementing until the condition is false
            counter+=2; // comparing i and pivot count as 2 operation increment i count as 1 operation
            while (array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
                counter+=1; // increment i count as 1 operation
            }

            // while element j in array is lexicographically greater than the pivot
            // j will keep decrementing until the condition is false
            counter+=2; // comparing j and pivot count as 2 operation
            while (array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
                counter+=1; // decrement j count as 1 operation
            }

            // if i is lower or equal than j
            counter+=2; // comparing i & j count as 2 operation
            if (i <= j) {
                // calling swap method
                swap(array, i, j);
                i++;
                j--;
                counter+=6; // calling a method count as 1 operation
                // the method passes 3 arguments count as 3 operation
                // increment & decrement count as 2 operation
            }
        }
        //call quickSort recursively based on given condition

        counter+=2; // comparing 2 element in the if statement count as 2 operation
        if (lowerIndex < j) {
            // calling a method that passes 3 parameter count as 4 operation
            counter+=4;
            // if the end lower index is smaller than j it will recursively call quicksort method again
            // but this time the parameter to be passed instead of higher index it will be j
            quickSort(array, lowerIndex, j);
        }

        counter+=2; // comparing 2 element in the if statement count as 2 operation
        if (i < higherIndex) {
            // calling a method that passes 3 parameter count as 4 operation
            counter+=4;
            // if i is smaller than higher index it will recursively call quicksort method again
            // but this time the parameter to be passed instead of lower index it will be i
            quickSort(array, i, higherIndex);
        }
    }

    void swap(String[] array, int i, int j) {
        // creating temp and assigning array[i] as temp count as 2 operation
        // swapping array[i] & array[j] count as 1 operation
        // assigning temp as array[j] count as 1 operation
        counter+=4;
        // the swap method is for swapping places between i & j in the array
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
