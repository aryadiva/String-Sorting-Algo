package com.basepak;

import java.util.List;

public class InsertionSort extends Thread{
    private int ins;
    public InsertionSort(int ins){
        this.ins = ins;
    }

     public int compareTo(InsertionSort insertion){
        int res = 0;
        if(this.ins < insertion.getId()){
            res = -1;
        }
        if(this.ins > insertion.getId()){
            res = 1;
        }
        return res;
     }

    public static void insertionSortArrayList(List<InsertionSort> list) {
        for (int j = 1; j < list.size(); j++) {
            InsertionSort current = list.get(j);
            int i = j-1;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
                list.set(i+1, list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }
}
