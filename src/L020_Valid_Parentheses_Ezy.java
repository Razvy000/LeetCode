import java.util.HashMap;
import java.util.Stack;


/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 but "(]" and "([)]" are not.
 */
public class L020_Valid_Parentheses_Ezy {

    // idea: add to stack, pop when found equal or not valid
    public boolean isValid(String s) {
        HashMap<Character, Character> left = new HashMap<Character, Character>();
        left.put('(', ')');
        left.put('[', ']');
        left.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            //System.out.println(stack);
            char c = s.charAt(i);

            if (left.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != left.get(stack.peek())) {
                return false;
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
