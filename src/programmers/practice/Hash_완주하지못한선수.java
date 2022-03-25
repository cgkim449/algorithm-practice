package programmers.practice;

import java.util.HashMap;

public class Hash_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : completion) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if (!hashMap.containsKey(s) || hashMap.get(s) == 0) {
                answer = s;
                break;
            }
            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) - 1);
            }
        }

        return answer;
    }
}
