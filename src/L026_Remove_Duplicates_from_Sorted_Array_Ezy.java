
/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/
public class L026_Remove_Duplicates_from_Sorted_Array_Ezy {

    // idea: two pointers, O(n) complexity
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n < 2)
            return n;

        int left = 0;
        int right = left;

        while (left < n && right < n) {
            if (nums[right] == nums[left]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                right++;
            }
        }

        return left + 1;
    }
}
