
import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class L228_Summary_Ranges_Ezy {

    public class Solution {

        public List<String> summaryRanges(int[] nums) {
            List<String> r = new ArrayList<>();

            if (nums.length == 1) {
                r.add(nums[0] + "");
                return r;
            }

            for (int i = 0; i < nums.length; i++) {
                int begin = nums[i];

                while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1)
                    i++;

                if (begin != nums[i])
                    r.add(begin + "->" + nums[i]);
                else
                    r.add(begin + "");

            }
            return r;
        }
    }
}
