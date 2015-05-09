/*
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */
 
public class L172_Factorial_Trailing_Zeroes_Ezy {

    // idea: number of 5*2 pair, number of 5 multiples
    // 15 = 3*5
    // 25 = 5*5
    // multiplii de 5 + multiplii de 25
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        
        return count;
    }

    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        return n / 5 + trailingZeroes(n / 5);
    }
}
