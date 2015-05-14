
/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */
public class L014_Longest_Common_Prefix_Ezy {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String j : strs) {
                if (i >= j.length() || c != j.charAt(i))
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}
