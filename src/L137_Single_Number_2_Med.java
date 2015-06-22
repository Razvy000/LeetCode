
/*
 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class L137_Single_Number_2_Med {

    // every bit in the 32 bit spot should appear 3 times
    public int singleNumber2(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }

    /*
     We can improve this based on the previous solution using three bitmask variables:

     ones as a bitmask to represent the ith bit had appeared once.
     twos as a bitmask to represent the ith bit had appeared twice.
     threes as a bitmask to represent the ith bit had appeared three times.

     When the ith bit had appeared for the third time, clear the ith bit of both ones and twos to 0. The final answer will be the value of ones.
     */
    int singleNumber(int A[]) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

}
