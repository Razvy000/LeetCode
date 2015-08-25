
import java.util.HashMap;

public class L242_Valid_Anagram_Ezy {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> occurences = new HashMap<>();
        
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
                        
            if(occurences.containsKey(c))
                occurences.put(c, occurences.get(c)+1);
            else
                occurences.put(c, 1);
        }
        
        for(int i=0; i< t.length(); i++){
            char c = t.charAt(i);
            if(occurences.containsKey(c)){
                if(occurences.get(c) <= 0)
                    return false;
                else
                    occurences.put(c, occurences.get(c)-1);
            }else{
                return false;
            }
        }
        
        for(Character c : occurences.keySet()){
            if(occurences.get(c) > 0)
                return false;
        }
        
        return true;
    }
}
