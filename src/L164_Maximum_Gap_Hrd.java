
public class L164_Maximum_Gap_Hrd {

    // idea:
    //  find min, max in O(n)
    //  N number of elements
    //  maximum gap > (max-min)/N
    // split numbers into N buckets
    // check edges of buckets
    // bucket should have min and max
    // it is count sorting for a different range
    //  1 1 4 5 8 9       N=6, min=1, max=9
    //  
    public int maximumGap(int[] num) {

        if (num.length < 2)
            return 0;

        int N = num.length;
        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }

        int r = (max - min) / N;
        //System.out.println(r);

        int[] bucketMin = new int[N + 1];
        int[] bucketMax = new int[N + 1];

        for (int i = 0; i < num.length; i++) {
            double pozz = (double) (num[i] - min) / (max - min) * N;
            //System.out.println(num[i] + " " + pozz);
            int poz = (int) pozz;
            //if(poz < 0){
            //    System.out.println("poz:" + poz);
            //   System.out.println("num: " + num[i]);
            //   System.out.println("min " + min);
            //   System.out.println("max "+ max);
            //   System.out.println("N " + N);
            //}
            if (bucketMin[poz] == 0) {
                bucketMin[poz] = num[i];
                bucketMax[poz] = num[i];
            }

            bucketMin[poz] = Math.min(bucketMin[poz], num[i]);
            bucketMax[poz] = Math.max(bucketMax[poz], num[i]);
        }

        int prev = 0;
        for (int i = 0; i < bucketMin.length; i++) {
            if (bucketMin[i] != 0) {
                r = Math.max(r, bucketMin[i] - bucketMax[prev]);
                prev = i;
            }

        }
        return (int) r;
    }
}
