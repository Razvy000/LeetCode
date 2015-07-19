
import java.util.HashMap;
import java.util.Map;

/*
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class L205_Isomorphic_Strings_Ezy {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic2(s, t) && isIsomorphic2(t, s);
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct)
                    return false;
            } else {
                map.put(cs, ct);
            }
        }

        return true;
    }
}
