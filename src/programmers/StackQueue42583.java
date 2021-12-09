package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date: 2021-12-09
 * Time: 10:28
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

/*
 * 이 문제 vs 데브매칭
 * 공통점: 큐에 예상 도착시간 넣어놓고 '최소값' 꺼내서 시간 점프
 * 차이점:
 * 1. 큐 vs 우선순위큐
 * 2. 시간점프 + 1씩 증가 vs 시간점프
 */
public class StackQueue42583 {
    public static void main(String[] args) {

        int[][] case1 = {{2}, {10}, {7,4,5,6}};
        int[][] case2 = {{100}, {100}, {10}};
        int[][] case3 = {{100}, {100}, {10,10,10,10,10,10,10,10,10,10}};

        Iterator<int[]> iterator = Arrays.stream(case1).iterator();
        System.out.println(solution(iterator.next()[0], iterator.next()[0], iterator.next()));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        if(truck_weights.length == 1) return time += bridge_length + 1; // 트럭 1개 밖에 없으면 바로 리턴

        ArrayList<Integer> truckList = new ArrayList<>(10000);
        for (int truck : truck_weights) truckList.add(truck);

        Queue<Integer> truckQueue = new LinkedList<>(truckList); // 트럭 큐
        Queue<Truck> arrivalTimeQueue = new LinkedList<>(); // 도착 예정 시간 큐
        boolean flag = true; // true 면 시간 1초 증가, false 면 시간 점프

        int truck = 0;
        while(!truckQueue.isEmpty()) {
            // true 면 시간 1초 증가, false 면 시간 점프
            time = flag ? ++time : arrivalTimeQueue.peek().time;

            // 맨 앞 트럭 현재 시각에 도착하는지 검사(시간 점프시에는 무조건 true)
            if(!arrivalTimeQueue.isEmpty() && arrivalTimeQueue.peek().time == time) {
                // 맨 앞 트럭이 다리에서 빠져나감
                weight += arrivalTimeQueue.poll().weight;
            }

            truck = truckQueue.peek(); // 다음 트럭
            if(weight >= truck) { // 출발할 수 있는지 검사
                if(truckQueue.size() == 1) return time += bridge_length; // 트럭 큐에 남은 트럭이 한 개면 리턴.

                arrivalTimeQueue.offer(new Truck(truckQueue.poll(), time + bridge_length)); // 트럭 출발. 도착 예정 시간 저장.
                weight -= truck;

                flag = weight >= truckQueue.peek(); // 바로 다음 트럭이 출발할 수 있으면 true, 못하면 false(왜냐면 시간 1증가해야되니까)
            }
        }
        return time;
    }
}

class Truck {
    int weight;
    int time;

    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}