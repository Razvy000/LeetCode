
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
 A P L S I I G
  Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class L006_ZigZag_Conversion_Ezy {

    // idea: discover the movement
    /*
     rows = 4
     A            G             M
       B        F    H         L
         C    E        I     K 
            D             J
       
     A, B, C, D, E, F, G, H, I, J    
     A, G, B, F, H, C, E, I, D, J
     0, 6,   1, 5, 7,  2,4,8
    
     rows = 3
     A       E       I
       B   D   F   H
         C       G
        
     rows = 2
     A   C
       B
      
     rows = 1
     A  B  C    
     */
    public String convert(String ss, int numRows) {

        // 0,   + 2*(n-1), + 2*(n-1), 
        // 1,   + 2*(n-2), + 2*1
        // 2,   + 2*(n-3), + 2*2
        // K,   + 2*(n-k-1),+ 2*k
        // n-1, + 2*1
        // n,   + 2*(n-1)
        int n = numRows;
        int next = 0;
        char[] s = ss.toCharArray();
        char[] chars = new char[s.length];

        for (int k = 0; k < n; k++) {

            int where = k;
            if (where >= s.length) {
                break;
            }
            chars[next++] = s[where];

            for (int i = 0;; i++) {

                int step;
                if (k == 0 || k == n - 1) {
                    step = 2 * (n - 1);
                } else {
                    step = (i % 2 == 0) ? 2 * (n - k - 1) : 2 * k;
                }
                if (n == 1) {
                    step = 1;
                }

                where += step;
                if (where >= s.length) {
                    break;
                }
                chars[next++] = s[where];
            }
        }

        return new String(chars);
    }
}
