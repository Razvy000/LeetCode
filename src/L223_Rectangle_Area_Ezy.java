
/*
 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class L223_Rectangle_Area_Ezy {

    // idee: project segments that overlap A1 + A2 -Aoverlap
    // area of overlap = multiply overlapping segments
    //         CD            GH
    //  AB            EF
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = area(A, B, C, D);
        int a2 = area(E, F, G, H);
        int a3 = overlap(A, C, E, G) * overlap(B, D, F, H);
        return a1 + a2 - a3;
    }

    int area(int A, int B, int C, int D) {
        int dx = Math.max(C - A, 0);
        int dy = Math.max(D - B, 0);
        return dx * dy;
    }

    // overlap segments [left1,righ1] with [left2, right2]
    int overlap(int left1, int right1, int left2, int right2) {
        if (right1 < left2 || right2 < left1)
            return 0;
        int maxLeft = Math.max(left1, left2);
        int minRight = Math.min(right1, right2);
        return minRight - maxLeft;
    }
}
