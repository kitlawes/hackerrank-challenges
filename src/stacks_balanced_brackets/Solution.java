package stacks_balanced_brackets;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static String removeEmptyBrackets(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.substring(i, i + 2).equals("()")
                    || expression.substring(i, i + 2).equals("{}")
                    || expression.substring(i, i + 2).equals("[]")) {
                return expression.substring(0, i) + expression.substring(i + 2);
            }
        }
        return expression;
    }

    public static boolean isBalanced(String expression) {

        while (expression.contains("()")
                || expression.contains("{}")
                || expression.contains("[]")) {
            expression = removeEmptyBrackets(expression);
        }
        if (expression.isEmpty()) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

}
