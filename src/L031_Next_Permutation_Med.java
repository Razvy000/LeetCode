
/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class L031_Next_Permutation_Med {

    // idea: pencil and paper
    // 5 1 4 2 3 >> 5 1 4 3 2
    // 5 1 4 3 2 >> 5 2 1 3 4 e bun exemplu
    // http://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
    /*
     The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
     Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
     Find the largest index l greater than k such that a[k] < a[l].
     Swap the value of a[k] with that of a[l].
     Reverse the sequence from a[k + 1] up to and including the final element a[n].
     */
    public void nextPermutation(int[] a) {
        // 1 2 3 4 5  >> 1 2 3 5 4
        // find first non-as from left to right
        // find greater than smallest

        // find largest index left such that a[left] < a[left+1]
        int left = a.length - 2;
        int right;
        for (; left >= 0 && a[left] >= a[left + 1]; left--) 
            ;

        //System.out.println(" left: " + left);
        if (left == -1) {
            // reverse seq
            left = left + 1;
            right = a.length - 1;
            while (left < right) {
                swap(a, left, right);
                left++;
                right--;
            }
            return;
        }

        // find largest index right such that a[left] < a[right]
        right = left + 1;
        for (int i = left + 1; i < a.length; i++) {
            if (a[left] < a[i]) {
                right = i;
            } else {
                break;
            }
        }

        //System.out.println(" left: " + left + " right: " + right);
        if (right == -1) {
            return;
        }

        // swap
        swap(a, left, right);

        // reverse seq
        left = left + 1;
        right = a.length - 1;
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation3(int[] num) {
        int i = num.length - 2;
        for (; i >= 0 && num[i] >= num[i + 1]; i--) 
            ;

        if (i >= 0) {
            int j = i + 1;
            for (; j < num.length && num[i] < num[j]; j++) 
                ;
            swap(num, i, j - 1);
        }

        i++;
        int k = num.length - 1;
        for (; i < k; i++, k--) {
            swap(num, i, k);
        }
    }

    private void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
