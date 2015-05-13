/*
 Implement int sqrt(int x).

 Compute and return the square root of x.
 */

public class L069_Sqrt_Med {

    // idea: binary search
    public int mySqrt(int x) {

        double min = 1;
        double max = x;
        
        // approximation
        double sqrtx = -1;
        
        while (true) {

            sqrtx = (min + max) / 2;
            sqrtx = (int) sqrtx;
            if (sqrtx == (int) min)
                return (int) sqrtx;
            
            // square the approximation
            double sqrtx2 = sqrtx * sqrtx;
            
            if (sqrtx2 < x)
                min = sqrtx;
            else if (sqrtx2 > x)
                max = sqrtx;
            else
                return (int) sqrtx;
        }
    }
}
