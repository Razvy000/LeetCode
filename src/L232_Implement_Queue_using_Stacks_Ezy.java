
import java.util.Stack;

/*
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class L232_Implement_Queue_using_Stacks_Ezy {

    Stack<Integer> s1 = new Stack<>();  // helper
    Stack<Integer> s2 = new Stack<>();  // in order for pop operation

    // idea keep them in easy pop order
    // push is a bit tricky
    public void push(int x) {
        while (s2.size() > 0)
            s1.push(s2.pop());

        s1.push(x);

        while (s1.size() > 0)
            s2.push(s1.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s2.isEmpty();
    }
}
