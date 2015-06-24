
import java.util.Set;


/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class L139_Word_Break_Med {

    // idea: dynamic programming
    // P[l] = true if the first substring of length l can be split
    public boolean wordBreak(String s, Set<String> dict) {
        // true if P[i]==true if the first i substring[0..i-1] can be split
        char[] a = s.toCharArray();
        int n = a.length;
        boolean P[] = new boolean[n + 1];
        P[0] = true;

        for (int l = 1; l <= n; l++) {
            for (String entry : dict) {
                int len = entry.length();
                if (l - len >= 0 && P[l - len] && equalArray(a, l - len, entry))
                    P[l] = true;
            }
        }

        return P[n];
    }

    boolean equalArray(char[] a, int start, String s) {
        for (int i = 0; i < s.length(); i++)
            if (a[start + i] != s.charAt(i))
                return false;
        return true;
    }
}
