
/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class L125_Valid_Palindrome_Ezy {

    public boolean isPalindrome(String S) {

        char[] s = S.toLowerCase().toCharArray();
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s[l])) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(s[r])) {
                r--;
                continue;
            }

            if (s[l] == s[r]) { // Character.toLowerCase
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
