package super_stack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] actual = superStack(new String[]{
                "push 1",
                "push 1",
                "push 1",
                "push 1",
                "push 1",
                "inc 1 1",
                "inc 2 1",
                "inc 3 1",
                "inc 4 1",
                "inc 5 1",
                "pop",
                "pop",
                "push 1",
                "push 1",
                "inc 1 1",
                "inc 2 1",
                "inc 3 1",
                "inc 4 1",
                "inc 5 1",
                "pop",
                "pop",
                "pop",
                "pop",
                "pop"
        });
        String[] expected = new String[]{
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "2",
                "3",
                "4",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "2",
                "3",
                "7",
                "9",
                "11",
                "E"
        };
        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i] + "\t" + expected[i]);
        }
    }

    public static String[] superStack(String[] operations) {
        String[] result = new String[operations.length];
        List<Integer> superStack = new ArrayList<Integer>();
        List<Integer> stackIncrements = new ArrayList<Integer>();
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            if (operation.startsWith("push")) {
                superStack.add(Integer.parseInt(operation.split(" ")[1]));
                stackIncrements.add(0);
            } else if (operation.startsWith("pop")) {
                superStack.remove(superStack.size() - 1);
                if (stackIncrements.size() >= 2) {
                    stackIncrements.set(stackIncrements.size() - 2, stackIncrements.get(stackIncrements.size() - 1) + stackIncrements.get(stackIncrements.size() - 2));
                }
                stackIncrements.remove(stackIncrements.size() - 1);
            } else if (operation.startsWith("inc")) {
                stackIncrements.set(Integer.parseInt(operation.split(" ")[1]) - 1,
                        stackIncrements.get(Integer.parseInt(operation.split(" ")[1]) - 1)
                        + Integer.parseInt(operation.split(" ")[2]));
            }
            if (superStack.isEmpty()) {
                result[i] = "E";
            } else {
                result[i] = String.valueOf(superStack.get(superStack.size() - 1) + stackIncrements.get(superStack.size() - 1));
            }
        }
        return result;
    }
}
