
import java.util.Arrays;

/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */
public class L075_Sort_Colors_Med {

    // idea counting sort
    public void sortColors2(int[] nums) {
        int[] clrs = new int[3];

        // count
        for (int i = 0; i < nums.length; i++)
            clrs[nums[i]]++;

        // write
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (clrs[j] == 0)
                j++;
            if (clrs[j]-- > 0)
                nums[i] = j;
        }
    }

    // idee: one pass
    // idee: one pass
    // place 0s to leftmost and 2s to rightmost by swapping
    // increment iterator when no swaps
    public void sortColors(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = n - 1;

        for (int i = 0; i < n && l < r;) {
            if (nums[i] == 0 && i >= l)
                swap(nums, i, l++);
            else if (nums[i] == 2 && i < r)
                swap(nums, i, r--);
            else
                i++;
        }
    }

    void swap(int[] v, int a, int b) {
        int t = v[a];
        v[a] = v[b];
        v[b] = t;
    }

    public static void main(String[] args) {
        L075_Sort_Colors_Med o = new L075_Sort_Colors_Med();
        int[] a = new int[]{1, 2, 0};
        o.sortColors(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{1, 1, 2};
        o.sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
