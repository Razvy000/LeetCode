import java.util.HashMap;
import java.util.Map;


/*
 Given a string, find the length of the longest substring without repeating characters. 
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 For "bbbbb" the longest substring is "b", with the length of 1.

 */
public class L003_Longest_Substring_Without_Repeating_Characters {

    // idea: store occurence position
    // limit len when occurence found
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;        

        Map<Character, Integer> pos = new HashMap<Character, Integer>();

        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            len++;

            if (pos.containsKey(c))
                len = Math.min(len, i - pos.get(c));

            maxLen = Math.max(maxLen, len);

            pos.put(c, i);
        }

        return maxLen;
    }
}
