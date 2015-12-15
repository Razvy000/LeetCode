/*
 iven an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */

public class L283_Move_Zeroes_Ezy {

    // idea: 2 pointers
    public void moveZeroes(int[] nums) {

        int left = 0;
        int nz = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            } else {
                nz++;
            }
        }

        for (int i = nums.length - nz; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
