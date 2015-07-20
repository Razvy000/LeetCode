
/*
 Given an integer, write a function to determine if it is a power of two.
 */
public class L231_Power_of_Two_Ezy {

    public boolean isPowerOfTwo(int n) {
        long n2 = n;

        if (n2 == 0)
            return false;

        return (n2 & (n2 - 1)) == 0;
    }
}
