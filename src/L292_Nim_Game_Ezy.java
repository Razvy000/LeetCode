
import java.util.HashMap;

/*
 You are playing the following Nim Game with your friend: 
 There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
 The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. 
 Write a function to determine whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */
public class L292_Nim_Game_Ezy {

    // 1 2 3 y
    // 4 n
    // 5 6 7 y
    // 8 n
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean canWinNim2(int n) {
        return helper(n);
    }

    HashMap<Integer, Boolean> cache = new HashMap<>();

    public boolean helper(int n) {
        if (cache.containsKey(n))
            return cache.get(n);

        if (n <= 3)
            return true;

        for (int i = 3; i >= 1; i--) {
            boolean h = helper(n - 3);
            if (h) {
                cache.put(n, false);
                return false;
            }
        }
        cache.put(n, true);
        return true;
    }
}
