
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class L049_Anagrams_Med {

    // idea: hashmap 
    // key = letters of string sorted
    // val = list of strings that are anagrams
    public List<String> anagrams(String[] strs) {

        List<String> res = new ArrayList<String>();

        if (strs == null || strs.length < 1) {
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            // make key
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // update map
            List<String> val = map.get(key);
            if (val == null) {
                val = new ArrayList<String>();
                map.put(key, val);
            }
            val.add(strs[i]);
        }

        // combine
        for (List<String> vals : map.values()) {
            if (vals.size() >= 2) {
                res.addAll(vals);
            }
        }

        return res;
    }
}
