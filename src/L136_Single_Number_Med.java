/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class L136_Single_Number_Med {

    // idea: if all elements appear twice, xoring all will equal 0
    // if one is missing then xoring equals the element
    public int singleNumber(int[] A) {
        int r = 0;
        for (int i = 0; i < A.length; i++)
            r ^= A[i];
        return r;
    }
}
