
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/

import java.util.ArrayList;
import java.util.List;

public class L210_Course_Schedule_2_Med {

    boolean[] visited;
    boolean[] flag;
    List<Integer>[] adjList;    

    // oder by labeling
    int[] order;
    int label;

    // idea: check if a cycle exists in the graph using dfs
    // idea: label nodes with a decreasing label after visiting them 
    public int[] findOrder(int n, int[][] prerequisites) {

        visited = new boolean[n];
        flag = new boolean[n];
        adjList = new List[n];
        
        order = new int[n];
        label = n - 1;

        // create adj list from edge list        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int j = 0; j < prerequisites.length; j++) {
            adjList[prerequisites[j][1]].add(prerequisites[j][0]);
        }

        // run for each node that wasn't flagged
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                if (dfs(i)) {
                    // has cycle
                    return new int[0];
                }
            }
        }

        return order;
    }

    // return true if found cycle
    boolean dfs(int root) {

        visited[root] = true;

        for (Integer child : adjList[root]) {

            if (visited[child])
                return true;

            boolean hasCycle = dfs(child);
            if (hasCycle)
                return true;
        }
        
        visited[root] = false;

        // label the nodes
        if (!flag[root])
            order[label--] = root;

        flag[root] = true;

        return false;
    }

    public static void main(String[] args) {
        L210_Course_Schedule_2_Med o = new L210_Course_Schedule_2_Med();
        // 2, [[0,1]]
        int[][] a = new int[][]{{0, 1}, {0, 2}};
        o.findOrder(3, a);
    }
}
