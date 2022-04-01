package programmers.practice;

import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 1;

        Queue<Integer> waitingQueue = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            waitingQueue.offer(truck_weight);
        }

        Queue<Truck> bridgeQueue = new LinkedList<>();

        while (!waitingQueue.isEmpty()) {
            // 현재 시간에 내려올수있는애를 먼저 내림
            if(!bridgeQueue.isEmpty() && time - bridgeQueue.peek().upTime == bridge_length) { // bridge length + 1이되면 내려감
                Truck t = bridgeQueue.poll();
                weight += t.weight;
            }

            // 현재 시간에 올라갈 수 있는 애를 올림
            int a = waitingQueue.peek();
            if(weight >= a) { // 다리로 올라갈수잇으면
                waitingQueue.poll();
                Truck t = new Truck(time, a);
                bridgeQueue.offer(t);
                time++;
                weight -= a;

            } else { // 다리로 못올라감
                // 일단 1초씩 증가시키자
                time++;
            }
        }
        // 웨이팅 큐 다 비웟으니 브릿지큐 비우자
        if(bridgeQueue.isEmpty()) {

        } else {
            while (bridgeQueue.size() != 1) {
                bridgeQueue.poll();
            }
            int tmp = bridge_length - (time - bridgeQueue.peek().upTime); // 내리는데 필요한시간
            time += tmp;
        }


        /* - 다리로 올라간 시간을 저장해놔야함
         * - 다리 큐에 최대한
         *  - 다리에서 하나 내려갈때마다 새로 다리에 올릴수잇는지 검사
         * - 다리길이 + 1이 총 걸리는 시간
         */

        return time;
    }
    
    static class Truck {
        int upTime;
        int weight;
        
        Truck(int upTime, int weight) {
            this.upTime = upTime;
            this.weight = weight;
        }
    }
}
