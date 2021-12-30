package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Hash42577_전화번호_목록 {
    public static void main(String[] args) {

        String[] s = {"119", "97674223", "1195524421"};
        String[] s1 = {"123","456","789"};
        String[] s2 = {"12","123","1235","567","88"};

        System.out.println(solution(s));
    }

    static public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        loop:
        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (set.contains(s.substring(0, j))) {
                    answer = false;
                    break loop;
                }
            }
        }
        return answer;
    }
}
