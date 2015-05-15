
/*
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */

public class L029_Divide_Two_Integers_Med {

    // idea: only positives
    // then fix input sign
    // idea: binary search, divide and conquer
    // idea: compute answer as a sum of powers of 2
    public int divide2(int dividend, int divisor) {

        // base case
        if (dividend < divisor) {
            return 0;
        }

        // recurse
        int r = divide(dividend >> 1, divisor);
        r = r << 1;

        // check
        if (dividend >= r * divisor + divisor)
            r += 1;

        return r;
    }

    int divide(int dividend, int divisor) {

        // junk for overflow
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1)
            return Integer.MAX_VALUE;

        int sign = (dividend > 0 ^ divisor > 0) ? -1 : 1;

        // compute r as a sum of powers of two
        long r = 0;
        long end = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);

        while (end >= sor) {

            // get power of two
            long power = 1;
            long tempsor = sor;

            while ((tempsor << 1) < end) {
                power <<= 1;
                tempsor <<= 1;
            }

            // add to r
            r += power;

            // update dividend
            end -= tempsor;
        }

        return (int) (sign * r);
    }

    public static void main(String[] args) {
        L029_Divide_Two_Integers_Med o = new L029_Divide_Two_Integers_Med();

        System.out.println(o.divide(-48, 7));
        System.out.println(o.divide(-1, 1));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int a = -1010369383;
        int b = -2147483648;
        System.out.println(a / b);
        System.out.println(o.divide(a, b));
    }
}
