package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2021-12-17
 * Time: 10:12
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Sort42746_가장큰수 {
    public static void main(String[] args) {

        int[] numbers1 = {0, 0, 0, 0};
        int[] test = new int[1001];
        for (int i = 0; i < test.length; i++) {
            test[i] = i;
        }

        System.out.println(solution(test));
    }
    public static String solution(int[] numbers) {
        boolean zero = true;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int n : numbers) {
            if (n != 0) {
                zero = false;
            }
            arrayList.add(n);
        }

        if(zero) {
            return "0";
        }

        Collections.sort(arrayList, (o1, o2) -> { // 3, 30
            int x = Integer.parseInt(o1 + String.valueOf(o2)); // 330
            int y = Integer.parseInt(o2 + String.valueOf(o1)); // 303
            // 330 > 303 -> o1 > o2
            return Integer.compare(y, x);
        });

        StringBuilder sb = new StringBuilder();
        for (int n : arrayList) {
            sb.append(n).append("\n");
        }

        return sb.toString();
    }
}
