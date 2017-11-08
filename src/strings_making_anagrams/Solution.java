package strings_making_anagrams;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    
    public static int numberNeeded(String first, String second) {

        int numberNeeded = 0;
        ArrayList<Character> firstArrayList = new ArrayList<Character>();
        for (Character character : first.toCharArray()) {
            firstArrayList.add(character);
        }
        ArrayList<Character> secondArrayList = new ArrayList<Character>();
        ArrayList<Character> secondArrayListCopy = new ArrayList<Character>();
        for (Character character : second.toCharArray()) {
            secondArrayList.add(character);
            secondArrayListCopy.add(character);
        }

        for (Character character : firstArrayList) {
            if (secondArrayList.contains(character)) {
                secondArrayList.remove(character);
            } else {
                numberNeeded++;
            }
        }
        for (Character character : secondArrayListCopy) {
            if (firstArrayList.contains(character)) {
                firstArrayList.remove(character);
            } else {
                numberNeeded++;
            }
        }

        return numberNeeded;

    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
}
