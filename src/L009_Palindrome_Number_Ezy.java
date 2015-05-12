/*
 Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */

public class L009_Palindrome_Number_Ezy {

    // idea: reverse int up to a half and compare
    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;

        // fear of overflow
        for (int i = 0; i < 16; i++) {
            rev = rev * 10 + x % 10;
            x /= 10;

            if (x == rev || x == rev / 10)
                return true;
        }
        return false;
    }
}
