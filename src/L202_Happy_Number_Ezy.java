
import java.util.HashSet;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/
public class L202_Happy_Number_Ezy {
    
    // idea: use a hashset to store path and check for loop
    // idea: use slow turtle and fast rabbit pointers to check for loop
    public boolean isHappy(int n){
        
        int slow = n;
        int fast = n;
        
        if(slow == 1)
                return true;
                
        while(true){
            slow = sumN(slow);
            if(slow == 1)
                return true;
                
            fast = sumN(sumN(fast));
            if(slow == fast)
                return false;
        }
    }
    
    int sumN(int n){
        int sum=0;
        while(n>0){
            int last = n % 10;
            n = n / 10;
            sum += last * last;
        }
        return sum;
    }
    
    public boolean isHappy2(int n) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        
        while(true){
            if(n==1)
                return true;
                
            int sum = 0;
            while(n>0){
                int last = n%10;
                n = n/10;
                sum+=last*last;
            }
            
            n = sum;
            
            if(set.contains(n))
                return false;
            else
                set.add(n);
        }
    }
    
}
