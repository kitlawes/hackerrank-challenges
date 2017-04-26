package tries_contacts;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> prefixCounts = new HashMap<String, Integer>();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add")){
                for(int a1 = 0; a1 <= contact.length(); a1++){
                    String prefix = contact.substring(0, a1);
                    if(prefixCounts.keySet().contains(prefix)){
                        prefixCounts.put(prefix, prefixCounts.get(prefix) + 1);
                    }else{
                        prefixCounts.put(prefix, 1);
                    }
                }
            }else if(op.equals("find")){
                if(prefixCounts.keySet().contains(contact)){
                    System.out.println(prefixCounts.get(contact));
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}