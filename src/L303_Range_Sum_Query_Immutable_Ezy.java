/*
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */

public class L303_Range_Sum_Query_Immutable_Ezy {

    public class NumArray {

        int[] presums;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            presums = new int[nums.length];
            if (nums.length > 0)
                presums[0] = nums[0];
            for (int i = 1; i < presums.length; i++) {
                presums[i] = presums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return presums[j] - presums[i] + nums[i];
        }
    }

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
