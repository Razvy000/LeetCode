
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class L071_Simplify_Path_Med {

    // idea use a stack and push/pop
    // dequeu is the new stack
    public String simplifyPath(String path) {
        String[] steps = path.split("/");

        // Stack<String> S2; deprecated, extends Vector
        Deque<String> S = new ArrayDeque<>();

        for (String step : steps) {
            if (step.isEmpty()) {
                continue;
            } else if (step.equals(".")) {
                continue;
            } else if (step.equals("..")) {
                if (!S.isEmpty())
                    S.pop();
            } else
                S.push(step);
        }

        String ans = "";
        while (!S.isEmpty()) {
            ans = S.pop() + "/" + ans;
        }
        ans = "/" + ans;
        if (ans.length() > 1)
            ans = ans.substring(0, ans.length() - 1);

        return ans.toString();
    }
}
