
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

*/

public class L179_Largest_Number_Med {
    
    Comparator<String> cmpLexiPadd = (String a, String b) -> {
        String s1 = a+b;
        String s2 = b+a;
        return s1.compareTo(s2);
    };
  
  // idea: sort them lexicografically (fun if u combine both ways) and combine
    public String largestNumber(List<Integer> num) {
        
        String[] nums = new String[num.size()];
        
        for(int i=0; i< nums.length ; i++)
            nums[i] = ""+num.get(i);
        
        Arrays.sort(nums, cmpLexiPadd);
        
        if(nums[nums.length-1].charAt(0)=='0')
            return "0";
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--)
            sb.append(nums[i]);
            
        return sb.toString();
    }
    
    
}
