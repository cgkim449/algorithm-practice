package programmers.practice;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int time = 0; // 현재시간
        int index = 0;
        int count = 0;

        while (index < progresses.length) {
            int tmp = progresses[index] + time * speeds[index];
            if(tmp >= 100) {
                count++;
                index++;
                continue;
            }
            if(count!=0) {
                arrayList.add(count);
            }
            count = 0;
            time += Math.ceil((100 - tmp) / (double)speeds[index]);
            count++;
            index++;
        }
        arrayList.add(count);

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
