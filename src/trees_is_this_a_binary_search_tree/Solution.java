package trees_is_this_a_binary_search_tree;

import java.util.Scanner;

public class Solution {
    
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

    class Node {
        int data;
        Node left;
        Node right;
     }
     
    boolean checkBST(Node root) {
        return checkNode(root.left, Integer.MIN_VALUE, root.data) && checkNode(root.right, root.data, Integer.MAX_VALUE);
    }

    boolean checkNode(Node root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        } else {
            return root.data > lowerBound
                && root.data < upperBound
                && checkNode(root.left, lowerBound, root.data)
                && checkNode(root.right, root.data, upperBound);   
        }
    }

}