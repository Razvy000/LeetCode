
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 

n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class L011_Container_With_Most_Water_Med {

    // idea: brute force, try all pairs of vertical walls O(n^2)
    // idea: start both ends, two pointers
    // area is limited by the smallest height
    // each step the width decreases
    // so move the smallest to have a chance at an area increase
    public int maxArea2(int[] height) {
        int n = height.length;

        int maxArea = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));

        return maxArea;
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
