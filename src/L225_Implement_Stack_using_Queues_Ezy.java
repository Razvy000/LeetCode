
import java.util.LinkedList;

/*
 Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class L225_Implement_Stack_using_Queues_Ezy {

    // idea: when popping use the extra q to store elemnts so you get the last one
    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q1.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {
            q2.addLast(q1.pollFirst());
        }

        q1.pollFirst();

        LinkedList<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    // Get the top element.
    public int top() {
        while (q1.size() > 1) {
            q2.addLast(q1.pollFirst());
        }

        int r = q1.pollFirst();
        q2.addLast(r);

        LinkedList<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return r;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

}
