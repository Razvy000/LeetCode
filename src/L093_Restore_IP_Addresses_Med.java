
import java.util.ArrayList;
import java.util.List;


/*
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 Backtracking String

 */
public class L093_Restore_IP_Addresses_Med {

    // 25525511135
    // 255.255.11.135
    // 2 55 255 
    // idea: backtracking, dfs
    // try cutting from string and recurse
    public List<String> restoreIpAddresses(String s) {
        return dfsHelper(s, 0);
    }

    public List<String> dfsHelper(String s, int idx) {
        List<String> ret = new ArrayList<>();
        if (idx == 3) {
            if (isValidOctet(s)) {
                ret.add(s);
            }
            return ret;
        }
        int len = s.length();
        for (int i = 1; i <= 3; ++i) {
            if (i <= len) {
                String cutHead = s.substring(0, i);
                if (!isValidOctet(cutHead))
                    continue;
                List<String> validTails = dfsHelper(s.substring(i), idx + 1);
                for (String tail : validTails) {
                    ret.add(cutHead + "." + tail);
                }
            }
        }
        return ret;
    }

    public boolean isValidOctet(String s) {
        if (s.length() > 3 || s.length() == 0)
            return false;
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        if (s.length() == 3 && Integer.parseInt(s) > 255)
            return false;
        return true;
    }
}
