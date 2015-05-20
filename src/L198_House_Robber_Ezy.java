
/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping 
you from robbing each of them is that adjacent houses have security system connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

*/

public class L198_House_Robber_Ezy {

    // P[i] = profit from robbing some houses between 0 and i inclusive
    // P[i] = max(do not rob house i, rob house i) 
    // P[i] = max(P[i-1], P[i-2] + nums[i])
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] P = new int[n];
        
        if(n==0)
            return 0;
        
        for(int i=0; i<n; i++){
            P[i] = Math.max(
                (i >= 1 ? P[i-1] : 0) , 
                (i >= 2 ? P[i-2] : 0) + nums[i]);
        }
        
        return P[n-1];
    }
}
