
/*
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class L028_Implement_strStr_Ezy {

    // idea: brute force not that bad for random strings
    // 1/26 chance to match 1 letter
    // 1/(26*26) to mach w letters
    
    // idea: Knuth-Morris-Pratt algo
    public int strStr(String haystack, String needle) {

        if (haystack.isEmpty() && needle.isEmpty())
            return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    found = false;
                    break;
                }
            }

            if (found)
                return i;
        }

        return -1;
    }
}
