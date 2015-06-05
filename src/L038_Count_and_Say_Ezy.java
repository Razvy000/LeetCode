
/*
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 */
public class L038_Count_and_Say_Ezy {

    // idea: just do it
    public String countAndSay(int n) {

        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = nextCountSay(s);
        }

        return s;
    }

    String nextCountSay(String s) {

        char prev = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                count = 1;
            }

            prev = c;
        }

        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }

    public static void main(String[] args) {
        L038_Count_and_Say_Ezy c = new L038_Count_and_Say_Ezy();
        String s = "1";
        for (int i = 0; i < 10; i++) {
            System.out.println(s);
            s = c.nextCountSay(s);
        }
        System.out.println(c.countAndSay(4));
    }

}
