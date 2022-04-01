package programmers.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Hash3 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> answerList = new ArrayList<>();
        Map<String, Integer> totalMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(totalMap.get(o2), totalMap.get(o1)));

        for (String s : totalMap.keySet()) {
            pq.offer(s);
        }

        Map<String, PriorityQueue<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            PriorityQueue<Integer> tempList = listMap.getOrDefault(genres[i]
                    , new PriorityQueue<>((o1, o2) -> {
                        if(plays[o1] > plays[o2]) {
                            return -1;
                        } else if(plays[o1] == plays[o2]) {
                            return o1.compareTo(o2);
                        } else {
                            return 1;
                        }
                    }));
            tempList.add(i);
            listMap.put(genres[i], tempList);
        }

        while (!pq.isEmpty()) {
            String s = pq.poll();
            PriorityQueue<Integer> temppq = listMap.get(s);
            answerList.add(temppq.poll());
            if(temppq.isEmpty()) {
                continue;
            }
            answerList.add(temppq.poll());
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}