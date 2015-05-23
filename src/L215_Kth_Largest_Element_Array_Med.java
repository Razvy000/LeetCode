
/*
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note: 
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class L215_Kth_Largest_Element_Array_Med {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findK(nums, nums.length - k, 0, nums.length - 1);
    }

    int findK(int[] nums, int k, int l, int r) {
        int pivotIdx = partition(nums, l, r);

        if (k < pivotIdx)
            return findK(nums, k, l, pivotIdx - 1);
        else if (k > pivotIdx)
            return findK(nums, k, pivotIdx + 1, r);
        else // k == pivotIdx
            return nums[k];
    }

    int partition(int[] a, int lo, int hi) {
        int pivotIdx = lo; // bad practice, use a choose function
        int pivotVal = a[pivotIdx];

        // put pivot last
        swap(a, pivotIdx, hi);
        int storeIdx = lo;

        for (int i = lo; i < hi; i++)
            if (a[i] <= pivotVal) {
                swap(a, i, storeIdx);
                storeIdx++;
            }
        swap(a, storeIdx, hi);
        return storeIdx;
    }

    void shuffle(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            int j = (int) (Math.random() * (i + 1)); // j=0..i
            swap(a, i, j);
        }
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        L215_Kth_Largest_Element_Array_Med o = new L215_Kth_Largest_Element_Array_Med();
        int r = o.findKthLargest(new int[]{2, 1}, 1);
        System.out.println(r);
    }
}
