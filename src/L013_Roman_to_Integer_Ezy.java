
import java.util.HashMap;

public class L013_Roman_to_Integer_Ezy {

    // idea: just take care of cases with XC, XL, CM    
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                char c2 = s.charAt(i + 1);
                // XC, XL, CM... cases
                if (map.get(c) < map.get(c2)){
                    res += map.get(c2) - map.get(c);
                    // eat both chars
                    i++;    
                }else{
                    res+=map.get(c);
                }        
            }else{
                res += map.get(c);
            }
            
        }
        return res;
    }
}
