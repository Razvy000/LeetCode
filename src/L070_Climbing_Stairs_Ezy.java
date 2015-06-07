
/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class L070_Climbing_Stairs_Ezy {

    // idea: a fibonacci
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int stepOne = 1;
        int stepTwo = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = stepOne + stepTwo;
            stepTwo = stepOne;
            stepOne = result;
        }
        return result;
    }

}
