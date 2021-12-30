package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 11:02
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Hash42578_위장 {
    public static void main(String[] args) {

        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes2));
    }

    static public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1); // 안입는거까지 계산할려고 맨 처음에 1을 넣음
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1; // 1 빼줌(전부 안입는 경우 하나 빼줘야됨)
    }
}
