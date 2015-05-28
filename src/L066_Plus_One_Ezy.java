
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class L066_Plus_One_Ezy {

    // -46 + 1 = [6,4] + 1 = [5,4]
    // [0,0,0,1] = [9,9,9]
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry = 1;
        List<Integer> l = new ArrayList<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            int d = digits[i] + carry;
            l.add(d % 10);
            carry = d / 10;
        }
        if (carry != 0)
            l.add(carry);

        Collections.reverse(l);

        int[] r = new int[l.size()];
        for (int i = 0; i < r.length; i++)
            r[i] = l.get(i);

        return r;
    }
}
