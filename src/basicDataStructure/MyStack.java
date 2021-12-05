package basicDataStructure;

import java.util.ArrayList;

/**
 * Created by cgkim449
 * Date: 2021-12-05
 * Time: 19:20
 */
public class MyStack<E> {
    // ArrayList
    private ArrayList<E> stack = new ArrayList<>();

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
