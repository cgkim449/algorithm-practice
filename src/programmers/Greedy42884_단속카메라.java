package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Date: 2021-12-30
 * Time: 08:34
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 */

public class Greedy42884_단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }
    static public int solution(int[][] routes) {

        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                int x = o1[1] - o1[0];
                int y = o2[1] - o2[0];
                return Integer.compare(x,y);
            } else {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        ArrayList<int[]> arrayList = new ArrayList<>(10000);

        loop:
        for (int[] x : routes) {
            for (int j = 0; j < arrayList.size(); j++) {
                int[] y = arrayList.get(j);
                if (y[0] <= x[1] && x[0] <= y[1]) {
                    int[] temp = new int[2];
                    temp[0] = Math.max(x[0], y[0]);
                    temp[1] = Math.min(x[1], y[1]);
                    arrayList.set(j, temp);
                    continue loop;
                }
            }
            arrayList.add(x);
        }

        return arrayList.size();
    }
}
