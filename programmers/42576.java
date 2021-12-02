import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        for (String s : completion) hashMap.put(s, hashMap.get(s) - 1);

        for (String s : hashMap.keySet()) {
            if(hashMap.get(s) == 1) {
                answer = s;
                break;
            }
        }

        return answer;
    }
}