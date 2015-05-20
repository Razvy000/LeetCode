
/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new 
place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class L213_House_Robber_2_Med {

    // P[i] = profit from robbing some houses between 0 and i inclusive
    // P[i] = max(do not rob house i, rob house i) 
    // P[i] = max(P[i-1], P[i-2] + nums[i]+check P[(i+1)%n] wasn't robbed)
    // wrap around using modular arithmetic
    public int rob(int[] nums) {

        int n = nums.length;
        int[][] P = new int[2][n];

        if (n == 0)
            return 0;

        for (int k = 0; k < 2; k++) {
            for (int i = k; i < n + k; i++) {
                P[k][i % n] = Math.max(
                        (i >= 1 ? P[k][i - 1] : 0),
                        (i >= 2 ? P[k][i - 2] : 0) + (P[k][(i + 1) % n] == 0 ? nums[i % n] : 0));
            }
        }

        return Math.max(P[0][n - 1], P[1][0]);
    }

    public static void main(String[] args) {
        L213_House_Robber_2_Med o = new L213_House_Robber_2_Med();
        System.out.println(o.rob(new int[]{2,3,4,2}));
    }
}
