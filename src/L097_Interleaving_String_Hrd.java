
/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class L097_Interleaving_String_Hrd {

    // idea: dinamic programming
    // Pij = true if the first i chars from 1st and j chars from 2nd string 
    // combine to make first i+j chars of the 3rd
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();
        boolean[][] P = new boolean[n + 1][m + 1];

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();

        P[0][0] = true;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {

                // edge cases
                if (i == 0 && j == 0)
                    P[0][0] = true;
                else if (i == 0)
                    P[i][j] = P[i][j - 1] && c[i + j - 1] == b[j - 1];
                else if (j == 0)
                    P[i][j] = P[i - 1][j] && c[i + j - 1] == a[i - 1];
                // general case
                else
                    P[i][j] = (P[i - 1][j] && c[i + j - 1] == a[i - 1])
                            || (P[i][j - 1] && c[i + j - 1] == b[j - 1]);
            }
        }

        return P[n][m];
    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "c";
        String c = "acb";

        L097_Interleaving_String_Hrd is = new L097_Interleaving_String_Hrd();
        boolean r = is.isInterleave(a, b, c);
        System.out.println(r);
    }
}
