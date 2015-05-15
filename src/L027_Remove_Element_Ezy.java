
/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class L027_Remove_Element_Ezy {

    // idea: two pointers
    public int removeElement(int[] nums, int val) {

        int l = -1;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] == val)
                r++;
            else
                nums[++l] = nums[r++];
        }

        return l + 1;
    }

    // assign to begin from current
    int removeElement2(int A[], int n, int elem) {
        int begin = 0;
        for (int i = 0; i < n; i++)
            if (A[i] != elem)
                A[begin++] = A[i];
        return begin;
    }

    // assign to current from end
    int removeElement3(int A[], int n, int elem) {
        int i = 0;
        while (i < n) {
            if (A[i] == elem) {
                A[i] = A[n - 1];
                n--;
            } else{
                i++;
            }
        }
        return n;
    }
}
