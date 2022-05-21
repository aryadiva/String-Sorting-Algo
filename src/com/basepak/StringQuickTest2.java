package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class StringQuickTest2 {
    static long counter = 0; // initialize counter for counting primitive operations

    public static void main(String[] args) throws IOException {
        StringQuickTest2 sorter = new StringQuickTest2(); // Creating an instance of an object to call
        counter+=2; // creating an object and assigning it to a variable

        File file = new File("src/com/basepak/clean_wordList.txt"); // Navigate the text file
        File txt = new File("Sorted.txt"); // creating a new file to store the sorted words
        FileWriter writer = new FileWriter(txt); // To write to the newly created file
        counter+=6; // each operations above has 2 primitive operations

        String[] str_list = new String[0]; // initializing str_list to store the string to array
        counter+=2; // creating/initializing array and assigning it to a string array
        try {
            Scanner myReader = new Scanner(file); // to scan the content of the file to be read
            List<String> list = new ArrayList<String>(); // creating an instance of list
            counter+=4; // myReader & list has both creating its instance and assigning them to a variable

            counter+=2; // creating while loop operation that has 1 condition count as 2 operation
            while (myReader.hasNext()) {
                // while myReader detect any next line it will add that line to list
                list.add(myReader.next());
                counter+=1; // each adding new element = 1 operation
            }
            int length = list.size(); // initialize length size
            counter+=2; // assigning list.size() as length and declare it as an integer variable

            str_list = new String[length]; // creating a new array to store the sorted words
            str_list = list.toArray(str_list); // converting list to array
            counter+=3;
            // assigning length as array size in str_list = 1 operation, and converting to array = 1 operation

            myReader.close(); // closing myReader
            counter+=1; // closing function count as 1 operation
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sorter.quickSort(str_list, 0, str_list.length-1);
            counter+=4; // calling an object = 1 operation
            // object has 3 parameter to be passed = 3 operation

            counter+=3; // creating a for loop count as 1 operation
            // creating a String x in str_list count as 2 operation
            for (String x : str_list) {
                System.out.println('['+x+']');
                counter+=1; // printing 1 element in the array count as 1 operation
            }

            //-------To write the sorted result to external txt file
            counter+=3; // creating a for loop that accept 3 condition count as 3 operation
            for(int i = 0; i < str_list.length; i++){
                writer.write('['+str_list[i]+']'+'\n'); // writing each element(i) in array to a new file
                counter+=1; // writing each element to a file count as 1 operation
                if(i == str_list.length-1){
                    writer.write('\n'+"Total primitive operations: "+counter);
                    counter+=1; // to write the total primitive operations in the new sorted file
                }
            }
            counter+=2; // closing writer & printing out total operations count as 2 operation
            writer.close();
            System.out.println("Total primitive operations: "+counter);
            // to display the total primitive operations in Java IDE(Intellij)
        }
    }

    public void quickSort(String[] array, int lowerIndex, int higherIndex) throws IOException {
        // no need to add counter for calling this method, because the counter has been counted in main when calling this method

        counter+=2; // creating an if statement that accept either/both of the condition
        // if the array is null or has length of 0 return this method without doing anything
        if (array == null || array.length == 0) {
            counter+=1; // returning nothing count as 1 operation
            return;
        }

        int i = lowerIndex; // set i as the lower index
        int j = higherIndex; // set j as the high index
        counter+=4; // setting i & j and assigning both of them as integer count as 2 operation each

        /*----------------------------------------------------------
        Random rand = new Random();
        int rand_index1 = rand.nextInt(j); // Average case = error
        String pivot = array[rand_index1];

        String pivot = array[higherIndex];  // worst case scenario
        String pivot = array[lowerIndex];   // worst case scenario
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
            while (array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
                counter+=3; // comparing i and pivot count as 2 operation and increment i count as 1 operation
            }

            // while element j in array is lexicographically greater than the pivot
            // j will keep decrementing until the condition is false
            while (array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
                counter+=3; // comparing j and pivot count as 2 operation and decrement j count as 1 operation
            }

            // if i is lower or equal than j
            if (i <= j) {
                // calling swap method
                swap(array, i, j);
                i++;
                j--;
                counter+=6; // calling a method that accept 3 parameter to be passed count as 4 operation
                // increment & decrement count as 2 operation
            }
        }
        //call quickSort recursively based on given condition

        counter+=3; // creating an if statement count as 1 operation
        // comparing 2 element in the if statement count as 2 operation
        if (lowerIndex < j) {
            // calling a method that passes 3 parameter count as 4 operation
            counter+=4;
            // if the end lower index is smaller than j it will recursively call quicksort method again
            // but this time the parameter to be passed instead of higher index it will be j
            quickSort(array, lowerIndex, j);
        }
        counter+=3; // creating an if statement count as 1 operation
        // comparing 2 element in the if statement count as 2 operation
        if (i < higherIndex) {
            // calling a method that passes 3 parameter count as 4 operation
            counter+=4;
            // if i is smaller than higher index it will recursively call quicksort method again
            // but this time the parameter to be passed instead of lower index it will be i
            quickSort(array, i, higherIndex);
        }
    }

    void swap(String[] array, int i, int j) {
        // the swap method is for swapping places between i & j in the array
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        counter+=4;
        // creating temp and assigning array[i] as temp count as 2 operation
        // swapping array[i] & array[j] count as 1 operation
        // assigning temp as array[j] count as 1 operation
    }
}
