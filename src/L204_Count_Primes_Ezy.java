/*
Count the number of prime numbers less than a non-negative number, n.
 */

public class L204_Count_Primes_Ezy {

    // sieve of eratosthenes
    public int countPrimes(int n) {
        // a = isPrime
        boolean[] a = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = true;
        }

        // make multiples false
        for (int i = 2; i * i < n; i++) {
            if (a[i] == true) {
                for (int j = i * i; j < n; j += i) {
                    a[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (a[i])
                count++;
        }
        return count;
    }
}
