
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class L187_Repeated_DNA_Sequences_Med {

    // idee use bit encoding for A C G T=> 4 comb =  2 bits
    // 10 ACTG seq = 1 int use 20 bits
    // just count
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> r = new ArrayList<>();

        if (s.length() < 10) {
            return r;
        }

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int[] a = transf(s.toCharArray());
        Arrays.sort(a);

        List<Integer> more = new ArrayList<Integer>();

        int seq = a[0];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == seq) {
                count++;
                if (count == 2) {
                    more.add(a[i]);
                }
            } else {
                seq = a[i];
                count = 1;
            }
        }

        for (Integer mor : more) {
            r.add(transf2(mor));
        }

        return r;
    }

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    int[] transf(char[] s) {
        int[] r = new int[s.length - 10 + 1];

        int buff = 0;
        for (int i = 0; i < s.length; i++) {
            buff = buff * 4 + map.get(s[i]);
            buff &= 0x000fffff; // keep only the last 20 bits
            if (i >= 9) {
                r[i - 9] = buff;
            }
        }

        return r;
    }

    String transf2(int x) {
        String s = "";
        for (int i = 0; i < 10; i++) {
            for (Character key : map.keySet()) {
                if (x % 4 == map.get(key)) {
                    s = key + s;
                }
            }
            x = x / 4;
        }
        return s;
    }
}
