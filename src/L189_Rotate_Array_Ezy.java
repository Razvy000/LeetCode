/*
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Hint:
 Could you do it in-place with O(1) extra space?
 Related problem: Reverse Words in a String II
 */

public class L189_Rotate_Array_Ezy {

    // idea: reverse 3 times: AB => A^tB^t , (A^tB^t)^t => BA
    void rotate(int nums[], int k) {
        int n = nums.length;
        k %= n; // if k > n then the final result is the same as k%n
        reverseArray(nums, n - k, n - 1);
        reverseArray(nums, 0, n - k - 1);
        reverseArray(nums, 0, n - 1);

    }

    /**
     * rotate the array nums from start to end
     *
     */
    void reverseArray(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
