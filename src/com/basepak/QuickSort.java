package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args){
        File file = new File("src/com/basepak/practice.txt");
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

            quickSort(str, 0, str.length-1);

            for (String x : str) {
                System.out.println('['+x+']');
            }

        }
    }

    private static void quickSort(String[] array){
        quickSort(array, 0, array.length-1);
    }
    private static void quickSort(String[] array, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int partitionIndex = partitioning(array, lowIndex, highIndex);

        // int pivotIndex = new Random().nextInt(highIndex-lowIndex)+lowIndex;
        //String pivot = array[highIndex];

        //swap(array, pivot, highIndex);

        //int lp = partitioning(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, partitionIndex-1);
        quickSort(array, partitionIndex+1, highIndex);


    }

    private static int partitioning(String[] array, int lowIndex, int highIndex) {
        String pivot = array[highIndex];
        int x = lowIndex-1;

        for(int j = lowIndex; j < highIndex; j++){
            if(array[j].compareToIgnoreCase(pivot)<0){
                x++;
            }
            String swapTemp = array[j];
            array[x] = array[j];
            array[j] = swapTemp;
        }
        String swapTemp = array[x+1];
        array[x+1] = array[highIndex];
        array[highIndex] = swapTemp;

        return x+1;

        /*
        int lp = lowIndex;
        int rp = highIndex;

        while(lp < rp){
            while(array[lp] <= pivot && lp < rp){
                lp++;
            }
            while(array[rp] >= pivot && lp < rp){
                rp--;
            }
            swap(array, lp, rp);
        }
        swap(array, lp, highIndex);
        return lp;

         */
    }

    private static void swap(String[] array, int index1, int index2){
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static void printArray(int[] numbers){
        for(int i=0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

}
