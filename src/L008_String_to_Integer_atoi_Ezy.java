
/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

 spoilers alert... click to show requirements for atoi.

 Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class L008_String_to_Integer_atoi_Ezy {

    // idea: devil details
    // "  010 "
    // "   -232893293829389"
    // "323abc238923"
    
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        char[] chars = str.toCharArray();

        if (chars[i] == '+') {
            sign = 1;
            i++;
        } else if (chars[i] == '-') {
            sign = -1;
            i++;
        }

        long n = 0;
        for (; i < chars.length; i++) {
            int digit = chars[i] - '0';

            if (digit < 0 || digit > 9) {
                return longToInt(sign * n);
            }

            if (sign * n < Integer.MIN_VALUE || sign * n > Integer.MAX_VALUE) {
                return longToInt(sign * n);
            }

            n *= 10;
            n += digit;
        }

        return longToInt(sign * n);
    }

    int longToInt(long n) {
        if (n < Integer.MIN_VALUE) {
            n = Integer.MIN_VALUE;
        }

        if (n > Integer.MAX_VALUE) {
            n = Integer.MAX_VALUE;
        }

        return (int) n;
    }
}
