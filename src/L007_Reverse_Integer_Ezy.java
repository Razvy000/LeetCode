
/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 Update (2014-11-10):
 Test cases had been added to test the overflow behavior.
 */
public class L007_Reverse_Integer_Ezy {

    // idea: consume lowest digit and create a new int
    public int reverse(int x) {
        
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return (Integer.MAX_VALUE >= rev && Integer.MIN_VALUE <= rev) ? (int) rev : 0;
    }
}
