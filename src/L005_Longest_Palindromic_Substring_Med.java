
/*
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, 
 and there exists one unique longest palindromic substring.
 */
public class L005_Longest_Palindromic_Substring_Med {

    // idea: dynamic programminc, increase len
    // P[i][j]= a[i]==a[j] && P[i+1][j-1]
    public String longestPalindrome(String s) {

        int savei = 0;
        int savej = 0;

        char[] a = s.toCharArray();
        int n = a.length;

        boolean[][] P = new boolean[n + 1][n + 1];

        // 1 leter strings are palindromes
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }

        // 2 same letters nearby are palindromes
        for (int i = 0; i <= n - 2; i++) {
            if (a[i] == a[i + 1]) {
                P[i][i + 1] = true;
                savei = i;
                savej = i + 1;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (j < n && a[i] == a[j] && i + 1 < n && j - 1 > 0 && P[i + 1][j - 1]) {
                    P[i][j] = true; // Pij = Pij | Pi+1j-1
                    savei = i;
                    savej = j;
                }

                // if(l%2==0 && j<n && a[i]==a[j] && i+1<n && j-1>0  && P[i][j-1]){
                //     P[i][j] = true; // Pij = Pij | Pi+1j-1
                //    savei = i;
                //     savej = j;
                // }
            }
        }

        for (int i = 0; i < n; i++) {
            //System.out.println(Arrays.toString(P[i]));
        }
        return s.substring(savei, savej + 1);
    }
}
