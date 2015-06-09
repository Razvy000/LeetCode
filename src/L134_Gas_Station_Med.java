/*
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */

public class L134_Gas_Station_Med {

    // idea: after reaching a point that we cannot pass, choose the next starting point here
    /*
     If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
     If the total number of gas is bigger than the total number of cost. There must be a solution.
     (Should I prove them?)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }

    // brute force O(n*n)
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++)
            if (can(gas, cost, i))
                return i;
        return -1;
    }

    public boolean can(int[] gas, int[] cost, int start) {
        int extra = 0;
        int n = gas.length;

        for (int i = start; i <= start + n; i++) {
            extra += gas[i % n];
            extra -= cost[i % n];
            if (extra < 0)
                return false;
        }
        return true;
    }
}
