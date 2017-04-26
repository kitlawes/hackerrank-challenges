package left_rotation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int result[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            if(a_i != 0){
                System.out.print(" ");
            }
            System.out.print(a[(a_i + k + n) % n]);
        }
    }
}