package com.basepak;

public class Main{

        public static void main(String[] args) throws Exception {

            int[] arr1 ={10, 8, 14, 6, 19, 8, 1, 2, 9};
            System.out.println("Before Insertion Sort");
            for(int i:arr1){
                System.out.print(i+"->");
            }
            System.out.println('\n');

            System.out.println("After insertion sort");

            for(int i:arr1){
                System.out.print(i+"->");
            }

            //ReadFileIntoArrayList readFileIntoArrayList = new ReadFileIntoArrayList();
            ReadFileIntoArrayList.main();

        }

}
