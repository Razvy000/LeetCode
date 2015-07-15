/*
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.
 */

public class L201_Bitwise_AND_of_Numbers_Range_Med {

    
    // idea: the result is equal to the leftmost equal bits of m and n

    public int rangeBitwiseAnd(int m, int n) {

        int r = Integer.MAX_VALUE; // 111111111 mask
        // r = 1111111111111
        // r = 1111111111110
        // r = 1111111111100

        while ((m & r) != (n & r)) 
            r = r << 1;                    // 1110
                                           // 1100
        return m & r;
    }
}
