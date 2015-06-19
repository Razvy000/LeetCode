
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class L127_Word_Ladder_Med {

    // idea: do a bfs search
    public int ladderLength(String start, String end, Set<String> dict) {

        dict.add(end);
        HashSet<String> visited = new HashSet<>();

        Queue<String> Q = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();
        Q.add(start);
        visited.add(start);
        distQ.add(1);
        while (!Q.isEmpty()) {
            String u = Q.remove();
            int currDist = distQ.remove();

            for (String v : getAdj(u, dict)) {

                if (v.equals(end))
                    return currDist + 1;

                if (!visited.contains(v)) {
                    visited.add(v);
                    Q.add(v);
                    distQ.add(currDist + 1);
                }
            }
        }

        return 0;
    }

    ArrayList<String> getAdj(String s, Set<String> set) {
        ArrayList<String> r = new ArrayList<>();
        set.stream().filter((entry) -> (countDiff(s, entry) == 1)).forEach((entry) -> {
            r.add(entry);
        });
        return r;
    }

    int countDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff == 2)
                    return diff;
            }
        }
        return diff;
    }
}
