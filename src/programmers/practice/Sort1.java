package programmers.practice;

import java.util.ArrayList;
import java.util.Collections;

public class Sort1 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = commands[i];
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = tmp[0] - 1; j <= tmp[1] - 1; j++) {
                arrayList.add(array[j]);
            }
            Collections.sort(arrayList);
            answer[i] = arrayList.get(tmp[2]-1);
        }

        return answer;
    }
}
