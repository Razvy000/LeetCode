
import java.util.ArrayDeque;
import java.util.Deque;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class L032_Longest_Valid_Parentheses_Hrd {

    // idea: dynamic programming
    // generate a()  (a) ()a, where a is valid
    // NU!   P[i,j] valid = P[i,j-2] '()' ||  '(' P[i+1,j-1] ')'  || '()' P[i+2, j]
    // P[i,j] valid = P[i,k]P[k,j] || '(' P[i+1,j-1] ')'
    // too many passes
    // one pass?    
    // ()()(())
    // ))))((((
    // use a stack
    // add indexes of (
    // pop if found )
    // else add ) index to stack
    // stack will have unmatched indexes )))((( 
    // find longest interval between the unmatched indexes
    public int longestValidParentheses(String s) {

        int n = s.length();
        char[] a = s.toCharArray();
        Deque<Integer> S = new ArrayDeque();
        for (int i = 0; i < n; i++) {

            if (a[i] == '(')
                S.addLast(i);
            // a[i] == ')'
            else {
                // has matching '(' on stack?
                if (!S.isEmpty() && a[S.getLast()] == '(')
                    S.removeLast();
                else
                    S.addLast(i);
            }
        }
        // all matched
        if (S.isEmpty())
            return n;

        // 0 1 2 3 4 5 6 7 8 9 10 $
        //     )     )     (      *
        // add sentinel to end
        S.addLast(n);
        int prev = -1;
        int max = 0;
        while (!S.isEmpty()) {
            int curr = S.removeFirst();
            int len = curr - prev - 1;
            prev = curr;
            max = Math.max(max, len);
        }
        return (max / 2) * 2;
    }

    // one pass DP
    // longest[], for any longest[i], it stores the longest length of valid parentheses which is end at i.
    //If s[i] is '(', set longest[i] to 0, because any string end with '(' cannot be a valid one. 
    //Else if s[i] is ')' 
    //  If s[i-1] is '(', longest[i] = longest[i-2] + 2 
    //  Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
    //For example, input "( ) ( ( ) )", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6. 
    int longestValidParentheses2(String S) {
        if (S.length() <= 1)
            return 0;
        char[] s = S.toCharArray();
        int curMax = 0;
        int[] longest = new int[s.length];
        for (int i = 1; i < s.length; i++) {
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
                    curMax = Math.max(longest[i], curMax);
                } else { // if s[i-1] == ')', combine the previous length.
                    int beforeParen = i - longest[i - 1] - 1; // (=beforeParen a )=currentParen 
                    if (beforeParen >= 0 && s[beforeParen] == '(') {
                        longest[i] = longest[i - 1] + 2 + ((beforeParen - 1 >= 0) ? longest[beforeParen - 1] : 0);
                        curMax = Math.max(longest[i], curMax);
                    }
                }
            }
            //else if s[i] == '(', skip it, because longest[i] must be 0
        }
        return curMax;
    }

    // no need to consider the condition "s[i-1] == '('" since "s[i-longest[i-1]-1] == '('" actually concludes this case.
    int longestValidParentheses3(String S) {
        if (S.length() <= 1)
            return 0;

        char[] s = S.toCharArray();
        int curMax = 0;
        int[] longest = new int[s.length];
        for (int i = 1; i < s.length; i++) {
            if (s[i] == ')' && i - longest[i - 1] - 1 >= 0 && s[i - longest[i - 1] - 1] == '(') {
                longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                curMax = Math.max(longest[i], curMax);
            }
        }
        return curMax;
    }

    public static void main(String[] args) {
        L032_Longest_Valid_Parentheses_Hrd v = new L032_Longest_Valid_Parentheses_Hrd();
        //int r = v.longestValidParentheses("))())(()))()(((()())(()(((()))))((()(())()((((()))())))())))()(()(()))))())(((())(()()))((())()())((()))(()(())(())((())((((()())()))((()(())()))()(()))))))()))(()))))()())()())()()()()()()()))()(((()()((()(())((()())))(()())))))))(()()(())())(()))))))()()())((((()()()())))))((())(())()()(()((()()))()()())(()())()))()(()(()())))))())()(())(()))(())()(())()((())()((((()()))())(((((())))())())(()((())((()()((((((())))(((())))))))(()()((((((()(((())()(()))(()())((()(((()((()(())())()())(((()))()(((()))))(())))(())()())()(((()))))((())())))())()()))((((()))(())()())()(((())(())(()()((())()())()()())())))((()())(()((()()()(()())(()))(()())((((()(()(((()(((())()((()(()))())()())))))))))))()())()(()(((())()))(((()))((((()())())(()())((()())(()()((()((((()())))()(())(())()))))(())())))))(((((((())(((((()))()))(()()()()))))))(()(()(()(()()(((()()))((()))())((())())()())()))()()(((())))()(())()()(())))(((()))))))))(())((()((()((()))))()()()((())((((((((((()(())))(())((()(()())())(((((((()()()()))())(((()())()(()()))))(()()))))(((()()((()()()(((()))))(()()())()()()(()))))()(())))))))()((((((((()((())))))))(()))()((()())())(");
        int r = v.longestValidParentheses(")(");
        System.out.println(r);

    }
}
