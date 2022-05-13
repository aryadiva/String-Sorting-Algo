package com.basepak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main{
        public static void main(String[] args) throws IOException {

            /*int[] arr1 ={10, 8, 14, 6, 19, 8, 1, 2, 9};
            System.out.println("Before Insertion Sort");
            for(int i:arr1){
                System.out.print(i+"->");
            }
            System.out.println('\n');

            System.out.println("After insertion sort");

            for(int i:arr1){
                System.out.print(i+"->");
            }*/

            //ReadFileIntoArrayList readFileIntoArrayList = new ReadFileIntoArrayList();

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

                for (String x : str_list) {
                    System.out.println(x);
                }
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

    private static void quickSort(String[] a, int lp, int rp) {

            if(a == null || a.length==0){
                return;
            }
        // index for the "left-to-right scan"
        int i = lp;
        // index for the "right-to-left scan"
        int j = rp;
        /*
        String pivott = a[lp+(rp-lp)/2];
        while(i<=j){
            while(a[i].compareToIgnoreCase(pivott)<0){
                i++;
            }

            while(a[i].compareToIgnoreCase(pivott)>0){
                j--;
            }
            if(i <= j){
                swap(a, i, j);
                i++;
                j--;
            }
        }

        // call quicksort recursively
        if(lp < j){
            quickSort(a, lp, j);
        }
        if(i<rp){
            quickSort(a, i, rp);
        }
        // only examine arrays of 2 or more elements.

             */

        if (j - i >= 1)
        {
            // The pivot point of the sort method is arbitrarily set to the first element int the array.
            String pivot = a[i];
            // only scan between the two indexes, until they meet.
            while (j > i)
            {
                // from the left, if the current element is lexicographically less than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the right or an element that is lexicographically greater than the pivot String.
                while (a[i].compareTo(pivot) < 0 && i <= rp && j > i){
                    i++;
                }
                // from the right, if the current element is lexicographically greater than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the left or an element that is lexicographically less than the pivot String.
                while (a[i].compareTo(pivot) > 0 && j >= lp && j >= i){
                    j--;
                }
                // check the two elements in the center, the last comparison before the scans cross.
                if (j > i)
                    swap(a, i, j);
            }
            // At this point, the two scans have crossed each other in the center of the array and stop.
            // The left partition and right partition contain the right groups of numbers but are not
            // sorted themselves. The following recursive code sorts the left and right partitions.

            // Swap the pivot point with the last element of the left partition.
            swap(a, lp, j);
            // sort left partition
            quickSort(a, lp, j - 1);
            // sort right partition
            quickSort(a, j + 1, rp);
        }


    }
    /**
     * This method facilitates the quickSort method's need to swap two elements, Towers of Hanoi style.
     */
    private static void swap(String[] a, int i, int j)
    {
        String temp = a[i]; // i
        a[i] = a[j]; // i, j
        a[j] = temp; // j, temp
    }
}

