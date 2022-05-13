package com.basepak;

import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Character>
    convertStrToCharList(String str){
        List<Character> chars = new ArrayList<>();

        for(char ch : str.toCharArray()){
            chars.add(ch);
        }
        return chars;
    }

    public static void main(String[] args){
        String str = "Devil_May_Cry";
        List<Character> chars = convertStrToCharList(str);

        System.out.println(chars);
    }
}
