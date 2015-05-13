
public class L010_Regular_Expression_Matching_Hrd {

    // idea care with the second char beeing *
    // eat string greedy? or eat all possible ways?
    public boolean isMatch2(String s, String p) {
        System.out.println(s + "  " + p);
        // base case
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // treat x* case
        if (p.length() > 1 && p.charAt(1) == '*') {

            // match nothing
            boolean r = isMatch(s.substring(0), p.substring(2));
            
            // treat . separately
            if (p.charAt(0) == '.') {
                int i = 0;
                while (i < s.length() && !r) {
                    r = r || isMatch(s.substring(i + 1), p);
                    i++;
                }
                return r;
            } else {
                int i = 0;
                while (i < s.length() && s.charAt(i) == p.charAt(0) && !r) {
                    r = r || isMatch(s.substring(i + 1), p);
                    i++;
                }
                return r;
            }
        } // treat no * case
        else {
            if (s.isEmpty())
                return p.isEmpty();

            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;

        }
    }

    // idea: clean and no substring operations
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean isMatch(char[] s, int sBegin, char[] p, int pBegin) {

        // base case
        if (pBegin >= p.length)
            return sBegin == s.length;

        // .* or a*
        if (pBegin + 1 < p.length && p[pBegin + 1] == '*') {
            // zero match
            if (isMatch(s, sBegin, p, pBegin + 2))
                return true;
            while (matchHead(s, sBegin, p, pBegin)) {
                if (isMatch(s, ++sBegin, p, pBegin + 2))
                    return true;
            }
            return false;
        } 
        
        // simple case
        else {
            if (matchHead(s, sBegin, p, pBegin))
                return isMatch(s, sBegin + 1, p, pBegin + 1);
            else
                return false;
        }
    }

    boolean matchHead(char[] s, int sBegin, char[] p, int pBegin) {
        return (sBegin < s.length && s[sBegin] == p[pBegin]) || (p[pBegin] == '.' && sBegin < s.length);
    }

    public static void main(String[] args) {
        L010_Regular_Expression_Matching_Hrd o = new L010_Regular_Expression_Matching_Hrd();
        System.out.println(o.isMatch("ab", ".*c"));
        System.out.println(o.isMatch("cd", ".*cd"));
        System.out.println(o.isMatch("cd", ".*d"));
        System.out.println(o.isMatch("aaa", ".*"));
        System.out.println(o.isMatch("a", ".*"));
        System.out.println(o.isMatch("", ".*"));

        System.out.println(o.isMatch("acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a"));
        System.out.println(o.isMatch("bbbb", ".*a*aa*a"));
        System.out.println("a".substring(0));
        System.out.println("[" + "a".substring(1) + "]");
    }
}
