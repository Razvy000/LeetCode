/*
 iven an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */

public class L283_Move_Zeroes_Ezy {

    // idea: 2 pointers
    // use left, or i - nzeros
    public void moveZeroes(int[] nums) {
        int nz = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]!=0){
                nums[i - nz] = nums[i];
                if(nz > 0)
                    nums[i] = 0;
            }else{
                nz++;
            }
        }
    }
}
