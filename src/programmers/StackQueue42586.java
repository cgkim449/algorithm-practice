package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021-12-07
 * Time: 12:34
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */

// 1. 1일마다 시뮬x (첫 배포 때마다 날짜 계산해서 날짜 점프)
// 2. 날짜 점프하고 나서 순회x (peek 할때마다 (날짜 * 스피드)를 더해줘서 오늘 배포할 수 있는지 검사)
public class StackQueue42586 {
    public static void main(String[] args) {

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses1, speeds1)));
    }

    public static Integer[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>(100);

        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.offer(progress);
        }

        // 1. 처음 한 개 배포
        // 2. 추가 배포
        // 3. 오늘 배포한 개수 배열에 저장

        int i = 0; // 스피드 배열의 인덱스
        int day = 0; // 오늘 날짜

        while(!queue.isEmpty()) {
            int count = 0; // 오늘 배포할 작업 개수
            
            // 1. 처음 한 개 배포
            
            int progress = queue.poll(); // 작업을 하나 꺼낸다
            count++;
            if(queue.isEmpty()) { // 큐에 남은 작업이 없으면 마지막 작업인거니까 걍 배포
                answerList.add(count);
                break;
            }

            // 작업 진행률 업데이트(+= 오늘 날짜 * 스피드)
            progress += day * speeds[i];

            // 추가로 필요한 날짜 계산해서 날짜를 점프
            day += (100 - progress) % speeds[i] == 0 ? (100 - progress) / speeds[i] : (100 - progress) / speeds[i] + 1;

            // 2. 추가 배포

            i++;
            while(true) { // 오늘 배포할 수 있는지 검사하여 배포
                progress = queue.peek();

                if(progress + day * speeds[i] >= 100) {
                    queue.poll();
                    count++; // 배포
                    i++;
                } else {
                    break;
                }

                if(queue.isEmpty()) {
                    break;
                }
            }

            // 3. 오늘 배포한 개수 배열에 저장
            answerList.add(count);
        }

        return answerList.toArray(new Integer[]{});
    }
}
