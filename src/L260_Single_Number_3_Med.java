/*
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class L260_Single_Number_3_Med {

    // idea: use XOR to find the XOR of the 2 numbers
    // because numbers are different there will be at least 1 bit difference between the 2
    // pick a bit (least significant) and split the numbers
    // do xor again
    public int[] singleNumber(int[] nums) {

        int xor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 ^= nums[i];
        }

        int differ = xor1 & (xor1 - 1); // remove least signif bit
        differ ^= xor1; // get the least signif bit
        // or do differ = xor1, differ &= -differ;

        // split and xor
        int[] r = {0, 0};
        for (int num : nums) {
            if ((num & differ) != 0)
                r[0] ^= num;
            else
                r[1] ^= num;
        }

        return r;
    }
}
