
import java.util.HashSet;

/**
Given an array of integers, find if the array contains any duplicates. 
* Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class L217_Contains_Duplicate_Ezy {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i< nums.length; i++)
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        return false;
    }
}
