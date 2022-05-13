package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringQuickSort {
    String names[];
    int length;

    public static void main(String[] args) {
        StringQuickSort sorter = new StringQuickSort();
        // String words[] = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"}; // the strings need to be sorted are put inside this array
        // sorter.sort(words);

        File file = new File("src/com/basepak/wordList.txt");
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

            sorter.sort(str);

            for (String x : str) {
                System.out.println('['+x+']');
            }

        }
    }

    private void sort(String array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        this.names = array;
        this.length = array.length;
        quickSort(0, length - 1);
    }

    public void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (this.names[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void swap(int i, int j) {
        String temp = this.names[i];
        this.names[i] = this.names[j];
        this.names[j] = temp;
    }
}
