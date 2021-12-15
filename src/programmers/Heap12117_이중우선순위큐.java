package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-15
 * Time: 11:14
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Heap12117_이중우선순위큐 {
    public static void main(String[] args) {

        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I 7","I 5","I -5","D -1"};

        System.out.println(Arrays.toString(solution(operations1)));
    }

    static public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1)); // 내림차순
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순

        boolean isEmpty = true;

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation, " ");

            String cmd = st.nextToken(); // 명령어
            int num = Integer.parseInt(st.nextToken()); // 숫자

            if(cmd.equals("I")) {
                maxHeap.offer(num); // 둘다 넣어주고
                minHeap.offer(num);
                isEmpty = false; // 넣어줬으니 false 로 바꿈
            } else {
                if(isEmpty) {
                    continue;
                }
                int max = maxHeap.peek();
                int min = minHeap.peek();

                if(max == min) { // 마지막 1개남았다는 뜻이므로
                    maxHeap.poll();
                    maxHeap.clear(); // 둘다 비워줌
                    minHeap.clear();
                    isEmpty = true; // 둘다 비워줬으니 true 로 바꿈
                    continue;
                }

                if(num == 1) {
                    maxHeap.poll();
                } else {
                    minHeap.poll();
                }
            }
        }

        if(!isEmpty) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}

/*
 * 단순히 우큐 두개 씀
 */