import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class L022_Generate_Parentheses_Med {

    // idea: if number of ( is greater of equal to ) up to a point it is ok
    public List<String> generateParenthesis2(int n) {
        paren("", n, n);
        return r;
    }

    ArrayList<String> r = new ArrayList<String>();
    
    void paren(String s, int left, int right) {
        if (left == 0 && right == 0) {
            r.add(s);
        }

        if (left > 0) {
            paren(s + '(', left - 1, right);
        }

        if (right > 0 && right > left) {
            paren(s + ')', left, right - 1);
        }
    }

    // DP idea: generate from existing using 2 parts
    // 0 empty
    // 1 ()
    // 2 ()(), (())  = (empty-0)+()-1, (()-1) +empty-0
    // 3 ()()(), ()(()),(())(),(()()),((())) 
    public static List<String> generateParenthesis(int n) {
        List<String>[] result = new List[n + 1];
        result[0] = Arrays.asList("");
        
        for (int i = 1; i <= n; i++) {
            List<String> r = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                for (String sl : result[j]) {
                    for (String sr : result[i - j - 1]) {
                        r.add("(" + sl + ")" + sr); // prove by example
                    }
                }
            }
            result[i] = r;
        }
        return result[n];
    }
}
