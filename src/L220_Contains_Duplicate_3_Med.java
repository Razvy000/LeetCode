
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, find out whether there are two distinct indices i and j 
in the array such that the
difference between nums[i] and nums[j] is at most t 
and the difference between i and j is at most k.
*/
public class L220_Contains_Duplicate_3_Med {

    // idea: cluster points by bucket-ing them by dividing them by t+1
    // they get into same bucket or nearby buckets
    // have a cluster for num[i]/(t+1) and a clustr for num[i]/(t+1) - 1    
    // key1 = nums[i]/(t+1), key2 = nums[i]/(t+1) - 1;  value=list<i>
    // take care with overflows
    // O(2*n*m) , n is number of elements, m is size of cluster
    public boolean containsNearbyAlmostDuplicate(int[] nums, int diff, int t) {

        Map<Integer, List<Integer>> occur = new HashMap<>();

        long t2 = (long) t + (t >= 0 ? 1 : -1);
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < 2; k++) {
                int key = (int) ((long) nums[i] / t2 - k);
                List<Integer> places = occur.get(key);
                if (places == null) {
                    places = new ArrayList<>();
                    occur.put(key, places);
                    places.add(i);
                } else {
                    for (Integer j : places) {
                        long valdiff = nums[i] - nums[j];
                        if (Math.abs(valdiff) <= (long) t && i - j <= diff)  // || nums[j] - nums[i] <=t
                            return true;
                    }
                    places.add(i);
                }
            }
        }
        return false;
    }

    
    // divide negative by t=> goes towards zero, so remap from Integer.MIN_VALUE
    // less space and time, O(n)
    // map of bucket to value
    // keep K entries in map
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;

            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public static void main(String[] args) {
        L220_Contains_Duplicate_3_Med o = new L220_Contains_Duplicate_3_Med();
        int[] a = new int[]{4, 2};
        int k = 2;  // i - j
        int t = 1;  // num[i] - num[j]        
        System.out.println(o.containsNearbyAlmostDuplicate(a, k, t));

        a = new int[]{-1, 2147483647};
        k = 1;
        t = 2147483647;
        System.out.println(o.containsNearbyAlmostDuplicate(a, k, t));

        System.out.println(2147483647);
        System.out.println(2147483647 + 1);
    }
}
