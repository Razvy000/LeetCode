import java.util.ArrayList;
import java.util.List;

/*
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class L017_Letter_Combinations_of_a_Phone_Number_Med {

    char[][] map = new char[][]{
        {' '},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},};

    ArrayList<String> r = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return r;
        }

        dfs(digits, "");
        return r;
    }

    void dfs(String digits, String sofar) {
        //System.out.println("|"+digits + "|" + sofar+"|");
        if (digits.length() == 0) {
            r.add(sofar);
            return;
        }
        
        int idx = digits.charAt(0) - '0';
        char[] maps = map[idx];
        for (int i = 0; i < maps.length; i++) {
            dfs(digits.substring(1), sofar + maps[i]);
        }
    }
}
