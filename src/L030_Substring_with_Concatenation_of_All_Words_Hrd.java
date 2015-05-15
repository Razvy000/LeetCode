
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class L030_Substring_with_Concatenation_of_All_Words_Hrd {

    // idea: make a histogram
    // idea: "all of the same length"! 
    public List<Integer> findSubstring(String s, String[] W) {

        List<Integer> r = new ArrayList<>();

        if (W.length == 0 || W[0].isEmpty() || W[0].length() > s.length())
            return r;

        int m = W[0].length();
        Map<String, Integer> hist = new HashMap<>();

        // create histogram
        for (String w : W)
            hist.put(w, hist.containsKey(w) ? hist.get(w) + 1 : 1);

        Map<String, Integer> currHist = new HashMap<>();
        // travel s
        for (int i = 0; i + m * W.length <= s.length(); i++) {

            if (hist.containsKey(s.substring(i, i + m))) {

                // create a new histogram
                currHist.clear();

                // travel W
                for (int j = 0; j < W.length; j++) {

                    String currw = s.substring(i + j * m, i + j * m + m);
                    Integer histC = hist.get(currw);
                    Integer currHistC = currHist.get(currw);
                    if (histC == null)
                        break;
                    else if (currHistC == null)
                        currHist.put(currw, 1);
                    else if (currHistC > histC)
                        break;
                    else
                        currHist.put(currw, currHistC + 1);
                }

                // compare hashcodes? or entries
                if (hist.equals(currHist))
                    r.add(i);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        L030_Substring_with_Concatenation_of_All_Words_Hrd o = new L030_Substring_with_Concatenation_of_All_Words_Hrd();

        System.out.println(o.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < 5000; i++) {
            a.append("ab");
        }
        String[] b = new String[200];
        for (int i = 0; i < 200; i += 2) {
            b[i] = "ab";
            b[i + 1] = "ba";
        }
        long t1 = System.currentTimeMillis();
        List<Integer> r = o.findSubstring(a.toString(), b);
        long t2 = System.currentTimeMillis();
        System.out.println(r);
        System.out.println(t2 - t1);
    }
}
