package basicDataStructure;

import java.util.ArrayList;

/**
 * Created by cgkim449
 * Date: 2021-12-05
 * Time: 18:57
 */
public class MyQueue<E> {
    // ArrayList
    private ArrayList<E> queue = new ArrayList<>();

    public boolean enqueue(E e) {
        return queue.add(e);
    }

    public E dequeue() {
       if(queue.isEmpty()) {
           return null;
       }
       return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        System.out.println(myQueue.enqueue("a"));
        System.out.println(myQueue.enqueue("b"));
        System.out.println(myQueue.enqueue("c"));
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
