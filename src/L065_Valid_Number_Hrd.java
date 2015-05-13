
/*
 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true

 Note: It is intended for the problem statement to be ambiguous. 
 You should gather all requirements up front before implementing one.

 */
public class L065_Valid_Number_Hrd {

    // idea: devil details
    public boolean isNumber(String s) {

        // remove white spaces
        char[] c = s.trim().toCharArray();

        if (c.length == 0)
            return false;

        // accept sign
        int i = 0, num = 0;
        if (c[i] == '+' || c[i] == '-')
            i++;

        // accept digits or  digits . digits 
        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;
        if (i < c.length && c[i] == '.')
            i++;
        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;

        if (num == 0)
            return false;

        // accept exponent
        if (i == c.length)
            return true;
        else if (i < c.length && c[i] != 'e')
            return false;
        else
            i++;

        // accept sign for the power
        num = 0;
        if (i < c.length && (c[i] == '+' || c[i] == '-'))
            i++;

        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;        
        if (num == 0)
            return false;

        // check if reached end
        if (i == c.length)
            return true;
        else
            return false;
    }
}
