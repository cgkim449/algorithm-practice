package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Date: 2021-12-08
 * Time: 11:59
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class StackQueue42587 {
    public static void main(String[] args) {

        int[][] case1 = {{2, 1, 3, 2}, {2}};
        int[][] case2 = {{1, 1, 9, 1, 1, 1}, {0}};

        System.out.println(solution(case2[0], case2[1][0]));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // key : 우선순위, value : 우선순위에 해당하는 애들의 개수
        for (int priority : priorities) {
            treeMap.put(priority, treeMap.getOrDefault(priority, 0) + 1);
        }

        while (!queue.isEmpty()) {
            int paper = queue.poll(); // 문서
            int priority = priorities[paper]; // 문서의 우선순위

            if(treeMap.higherKey(priority) != null) { // 우선순위가 더 높은 애가 존재하면
                queue.offer(paper); // 큐의 맨 뒤로 보낸다
            } else {
                answer++;

                if(paper == location) { // location 이랑 같으면 break
                    break;
                }

                treeMap.put(priority, treeMap.get(priority)-1); // value - 1 해줌

                if(treeMap.get(priority) == 0) { // value == 0 이면 맵에서 아예 제거해줌
                    treeMap.remove(priority);
                }
            }
        }
        return answer;
    }
}
