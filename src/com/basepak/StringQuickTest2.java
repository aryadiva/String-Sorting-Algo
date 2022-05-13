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
    static long counter_alt = 0;

    public static void main(String[] args) throws IOException {
        StringQuickTest2 sorter = new StringQuickTest2();

        File file = new File("src/com/basepak/practice.txt");
        File txt = new File("Sorted.txt");
        FileWriter writer = new FileWriter(txt);

        String[] str_list = new String[0];
        try {
            Scanner myReader = new Scanner(file);
            List<String> list = new ArrayList<String>();

            while (myReader.hasNext()) {
                list.add(myReader.next());
                //System.out.println(data);
            }
            // System.out.println(list);
            // System.out.println(list.get(1));
            int length = list.size();

            str_list = new String[length];
            str_list = list.toArray(str_list);
            /*
            for (String x : str_list) {
                System.out.println(x);
            }

             */
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            String[] str = str_list;

            sorter.quickSort(str, 0, str.length-1);

            for (String x : str) {
                System.out.println('['+x+']');
            }
            long total_count = counter+counter_alt;
            System.out.println("Total primitive operations: "+total_count);

            for(int i = 0; i < str.length; i++){
                writer.write('['+str[i]+']'+'\n');
                if(i == str.length-1){
                    writer.write('\n'+"Total primitive operations: "+total_count);
                }
            }
            writer.close();
        }
    }

    public void quickSort(String[] array, int lowerIndex, int higherIndex) {

        Random rand = new Random();

        int arr_length = array.length;

        if (array == null || arr_length == 0) {
            counter+=1;
            return;
        }
        int randIndex = rand.nextInt(arr_length);

        int i = lowerIndex;
        int j = higherIndex;
        //String pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        String pivot = array[(int) randIndex];
        counter+=6;

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
        counter_alt+=3;
    }
}
