
/*
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class L268_Missing_Number_Med {

    // idea: place numbers except 0 in their spots
    // place of zero is the missing number
    // a[0] = 1
    // a[1] = 2
    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] - 1 >= 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return i + 1;
        }

        return 0;
    }

    void swap(int[] a, int x, int y) {

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
