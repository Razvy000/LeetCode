
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

public class L166_Fraction_to_Recurring_Decimal_Med {

    // idea: get the digits from a division to any precision
    // idea: 1/prime1*prime2 where prime1 is coprime to 10 should give decimal repetitions
    String fractDigits(int a, int b, int minLen) {

        int rest = a % b;
        StringBuilder ans = new StringBuilder();
        while (ans.length() < minLen) {
            int digit = rest * 10 / b;
            ans.append(digit);
            rest = rest * 10 - digit * b;
        }

        return ans.toString();
    }

    // idea: O(1) space:
    // treat the stream of ints as list with possible cycle
    public String fractionToDecimal2(int aa, int bb) {

        long a = aa;
        long b = bb;
        long gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;

        String sign = ((a > 0) ^ (b > 0)) ? "-" : "";
        b = Math.abs(b);
        a = Math.abs(a);
        long rest = Math.abs(a % b);
        long rest1 = rest;
        long rest2 = rest;

        // first meet point
        do {
            long d1 = rest1 * 10 / b;
            rest1 = rest1 * 10 - d1 * b;

            long d2 = rest2 * 10 / b;
            rest2 = rest2 * 10 - d2 * b;
            long d22 = rest2 * 10 / b;
            rest2 = rest2 * 10 - d22 * b;
        } while (rest1 != rest2);

        String begin = "";
        String end = "";

        // second meet
        // add to begin
        long rest3 = rest;
        while (rest1 != rest3) {
            long d1 = rest1 * 10 / b;
            rest1 = rest1 * 10 - d1 * b;

            long d3 = rest3 * 10 / b;
            rest3 = rest3 * 10 - d3 * b;
            begin += d3;
        }

        // runner1 wrap around
        // add to end
        do {
            long d1 = rest1 * 10 / b;
            rest1 = rest1 * 10 - d1 * b;
            end += d1;
        } while (rest1 != rest3);

        String r = sign + (a / b) + "." + begin + "(" + end + ")";
        return r.replace("(0)", "").replaceAll("\\.$", "");
    }

    long gcd(long a, long b) {
        long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        L166_Fraction_to_Recurring_Decimal_Med f = new L166_Fraction_to_Recurring_Decimal_Med();

//        out.println(1.0 / 49);
//        out.println(1.0 / 214748364);
//        
//        out.println(3.0/49);
//        out.println(f.fractDigits(100, 7, 100));
//        out.println(f.fractionToDecimal(3, 49));
//        out.println(f.fractionToDecimal(1, 3));
//        
//        out.println(1234.0/ 99900);
        out.println(f.fractionToDecimal(1234, 999000));
        out.println(f.fractionToDecimal(1, 214748364));
        out.println(f.fractionToDecimal2(1, 214748364));
    }

}
