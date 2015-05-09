import java.util.Arrays;

/*
 Given an array of size n, find the majority element. 
 The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class L169_Majority_Element_Ezy {

    // idea: sort and majority should be at middle and at one of the ends
    // idea: hashmap count occurences
    // idea: increment for same number decrement for different
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] num) {

        int majr = num[0];
        int count = 1;

        for (int i = 1; i < num.length; i++) {

            // asume another is the major element
            if (count == 0) {
                count++;
                majr = num[i];
            } else if (majr == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majr;
    }
}
