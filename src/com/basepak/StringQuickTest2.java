package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StringQuickTest2 {
    static long counter = 0;

    public static void main(String[] args) throws IOException {
        StringQuickTest2 sorter = new StringQuickTest2(); // Creating an instance of an object to call

        File file = new File("src/com/basepak/wordList.txt"); // Navigate the text file
        File txt = new File("Sorted.txt"); // creating a new file to store the sorted words
        FileWriter writer = new FileWriter(txt); // To write to the newly created file

        String[] str_list = new String[0]; // initializing str_list to store the string to array
        counter+=5;
        try {
            Scanner myReader = new Scanner(file); // to scan the content of the file to be read
            List<String> list = new ArrayList<String>(); // creating an instance of list
            counter+=2;

            while (myReader.hasNext()) {
                // while myReader detect any next line it will add that line
                list.add(myReader.next());
                counter+=1;
            }
            int length = list.size(); // initialize length size

            str_list = new String[length];
            str_list = list.toArray(str_list);

            myReader.close();
            counter+=4;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            String[] str = str_list;

            sorter.quickSort(str, 0, str.length-1);
            counter+=3;

            for (String x : str) {
                System.out.println('['+x+']');
                counter+=1;
            }
            System.out.println("Total primitive operations: "+counter);
            System.out.println(str.length);

            /* To write the sorted result to external txt file
            for(int i = 0; i < str.length; i++){
                writer.write('['+str[i]+']'+'\n');
                counter+=1;
                if(i == str.length-1){
                    writer.write('\n'+"Total primitive operations: "+counter);
                    counter+=1;
                }
            }
            writer.close();

             */
            //counter+=1;
        }
    }

    public void quickSort(String[] array, int lowerIndex, int higherIndex) {
        Random rand = new Random();
        int arr_length = array.length;

        if (array == null || arr_length == 0) {
            counter+=1;
            return;
        }

        int i = lowerIndex;
        int j = higherIndex;

        String pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2]; // Best case scenario

        //int rand_index1 = rand.nextInt(142301); // Average case = error?
        //String pivot = array[rand_index1-1];

        //String pivot = array[higherIndex];  // worst case scenario

        counter+=7;

        while (i <= j) {
            counter+=1;
            while (array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
                counter+=2;
            }

            while (array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
                counter+=2;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
                counter+=4;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(array, lowerIndex, j);
            counter+=2;
        }
        if (i < higherIndex) {
            quickSort(array, i, higherIndex);
            counter+=2;
        }
    }

    void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        counter+=3;
    }
}
