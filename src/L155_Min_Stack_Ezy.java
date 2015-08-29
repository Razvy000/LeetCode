
import java.util.ArrayDeque;
import java.util.Deque;

/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */

public class L155_Min_Stack_Ezy {
    
    Deque<Integer> S = new ArrayDeque<>();
    Deque<Integer> Smin = new ArrayDeque<>();

    // idea: have a separate stack for min
    public void push(int x) {
        S.push(x);
        if (Smin.isEmpty() || x <= Smin.peek())
            Smin.push(x);
    }

    public void pop() {
        int poped = S.pop();
        if (!Smin.isEmpty() && Smin.peek() == poped)
            Smin.pop();
    }

    public int top() {
        return S.peek();
    }

    public int getMin() {
        return Smin.peek();
    }

}
