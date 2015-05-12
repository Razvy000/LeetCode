/*
 Implement pow(x, n).
 */

public class L050_Pow_Med {

    // idea: binary search, divide and conquer
    public double pow(double x, int n) {
        if (n < 0)
            return 1 / power(x, -n);
        else
            return power(x, n);
    }

    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double p = power(x, n / 2);

        if (n % 2 == 0)
            return p * p;
        else
            return p * p * x;
    }
}
