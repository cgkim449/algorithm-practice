package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Date: 2021-12-14
 * Time: 13:23
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Heap42627_디스크_컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> diskQueue =  new PriorityQueue<>((o1, o2) -> { // 디스크 큐
            if(o1[1] == o2[1]) { // 소요시간이 같은 경우
                return Integer.compare(o1[0], o2[0]); // 요청시점의 오름차순
            }
            return Integer.compare(o1[1], o2[1]); // 소요시간의 오름차순
        });

        PriorityQueue<int[]> jobQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0])); // 작업 큐. 요청시점의 오름차순.

        for (int[] job : jobs) {
            jobQueue.offer(job);
        }

        int time = 0;
        while(true) {
            if(diskQueue.isEmpty()) { // 디스크 큐가 비어있으면 먼저 요청이 들어온 작업부터 처리한다
                if(jobQueue.isEmpty()) {
                    break;
                }
                time = jobQueue.peek()[0];// 작업 큐 맨 앞에 있는 작업의 요청시점으로 시간 점프

                while(!jobQueue.isEmpty() && jobQueue.peek()[0] == time) { // 현재 시간이 요청시점인 작업들을 전부 디스크 큐에 넣는다
                    diskQueue.offer(jobQueue.poll());
                }
                continue; // 이제 디스크 큐가 안 비어있다!!
            }

            // 디스크 큐가 안 비어있는 경우
            int[] x = diskQueue.poll(); // 작업을 꺼낸다
            time += x[1]; // 작업을 실행한다
            answer += (time - x[0]); // (현재시간 - 요청시간)

            while(!jobQueue.isEmpty() && jobQueue.peek()[0] <= time) {// 시간을 점프했으므로 그 전 시간에 요청했던 애들은 전부 큐에 넣어야한다
                diskQueue.offer(jobQueue.poll());
            }
        }

        return answer / jobs.length;
    }
}

/*
    if(jobQueue.peek()[0] > time) {
        int[] x = jobQueue.poll();
        time = x[0];
        if(jobQueue.isEmpty()) {
            continue;
        }
        diskQueue.offer(x); // 이거 안써서 계속 맞왜틀
        while(!jobQueue.isEmpty() && jobQueue.peek()[0] == time) {
            diskQueue.offer(jobQueue.poll());
        }
        continue;
    }

    //////////////////////////////////////////////////////////////////////////

    if(jobQueue.peek()[0] > time) {

    이거 필요없이 걍 time = jobQueue.peek()[0]; 이거 한줄이면 되는 거 알고는 있었는데
    걍 했다가 offer 하는거 빼먹어서 계속 맞왜틀
 */

/*
 * 이게 왜 최소값인지는 나름 생각은 했으나 증명은 모르겟음
 */