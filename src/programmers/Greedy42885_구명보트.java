package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Date: 2021-12-29
 * Time: 09:21
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Greedy42885_구명보트 {
    public static void main(String[] args) {
        int[] people = new int[]{70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int person : people) {
            arrayList.add(person);
        }

        Collections.sort(arrayList);
        Deque<Integer> deque = new LinkedList<>(arrayList);

        int count = 0;

        while (true) {
            if(deque.isEmpty()) return count;

            int x = deque.pollLast();
            count++;

            if(deque.isEmpty()) return count;

            int y = deque.peekFirst();
            if(limit >= x + y) deque.pollFirst();
        }
    }
}
