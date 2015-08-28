
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.
 */
public class L264_Ugly_Number_2_Med {

    // idea given a number k, generate 3 numbers: 2k, 3k, 5k
    // how to compare 2k,3k,5k with 2k2,3k2,5k2, even if i know k < k2
    // have 3 priority queues, exact min over all, generate 3 more numbers and add to queues
    /*
     The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5
     */
    PriorityQueue<Integer> Q2 = new PriorityQueue<>();
    PriorityQueue<Integer> Q3 = new PriorityQueue<>();
    PriorityQueue<Integer> Q5 = new PriorityQueue<>();

    // dupes problem - not good
    public int nthUglyNumber2(int n) {

        int el = 1;

        List<PriorityQueue<Integer>> Qs = new ArrayList<>();
        Qs.add(Q2);
        Qs.add(Q3);
        Qs.add(Q5);

        for (int i = 0; i < n; i++) {

            // add
            Q2.add(2 * el);
            Q3.add(3 * el);
            Q5.add(5 * el);

            int min = Integer.MAX_VALUE;
            PriorityQueue<Integer> Qsel = null;
            for (PriorityQueue<Integer> Q : Qs) {
                if (min > Q.peek()) {
                    min = Math.min(min, Q.peek());
                    Qsel = Q;
                }
            }

            el = Qsel.poll();
        }

        return el;
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        L264_Ugly_Number_2_Med o = new L264_Ugly_Number_2_Med();

        for (int i = 1; i < 10; i++) {
            System.out.println(o.nthUglyNumber(i));
        }
    }
}
