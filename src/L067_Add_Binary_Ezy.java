
/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class L067_Add_Binary_Ezy {

    public String addBinary(String a, String b) {
        int carry = 0;
        int n = a.length();
        int m = b.length();
        int len = Math.max(n, m);

        StringBuilder c = new StringBuilder();

        for (int i = 0; i < len || carry > 0; i++) {
            int r = carry
                    + ((n - 1 - i >= 0) ? (a.charAt(n - 1 - i) - '0') : 0)
                    + ((m - 1 - i >= 0) ? (b.charAt(m - 1 - i) - '0') : 0);
            carry = r >> 1;
            c.insert(0, Integer.toString(r & 1));
        }

        return c.toString();

    }
}
