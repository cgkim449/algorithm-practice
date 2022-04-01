package programmers.practice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {

    }

    public static int solution(int[] priorities, int location) {

        Queue<Integer> locationQueue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            priorityQueue.offer(priority);
        }

        for (int i = 0; i < priorities.length; i++) {
            locationQueue.offer(i);
        }

        int count = 0;

        while (true) {
            int i = locationQueue.peek();
            int x = priorities[i];
            int y = priorityQueue.peek();
            if(x == y) {
                if(location == i) {
                    count++;
                    return count;
                } else {
                    locationQueue.poll();
                    priorityQueue.poll();
                    count++;
                }
            } else {
                locationQueue.offer(locationQueue.poll());
            }
        }
    }
}
/*
 * 큐나 스택에 인덱스 넣기
 * 큐 2개 쓰기
 */
