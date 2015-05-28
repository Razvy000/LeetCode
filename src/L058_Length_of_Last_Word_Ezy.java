
/*
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example, 
 Given s = "Hello World",
 return 5.
 */
public class L058_Length_of_Last_Word_Ezy {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;
        int idx = s.lastIndexOf(' ');
        if (idx == -1)
            return s.length();
        return s.length() - idx - 1;
    }
}
