package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by cgkim449
 * Date: 2021-12-06
 * Time: 13:16
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class Hash42579_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
    static public Integer[] solution(String[] genres, int[] plays) {

        HashMap<String, PriorityQueue<Integer>> playsMap = new HashMap<>(); // key: 장르, value: 고유번호 우선순위 큐(플레이 시간 내림차순. 플레이 시간 같으면 고유 번호 오름차순)
        HashMap<String, Integer> totalTimeMap = new HashMap<>(); // key: 장르, value: 총 시간

        // 맵들을 다 채움
        fillAllMaps(genres, plays, playsMap, totalTimeMap);

        // entrySet을 '총 시간'의 내림차순으로 정렬
        TreeSet<Map.Entry<String, Integer>> entrySet = new TreeSet<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        entrySet.addAll(totalTimeMap.entrySet());

        // 2개씩(또는 한개)꺼내서 담기
        return getAnswerList(playsMap, entrySet).toArray(new Integer[0]);
    }

    private static ArrayList<Integer> getAnswerList(HashMap<String, PriorityQueue<Integer>> playsMap, TreeSet<Map.Entry<String, Integer>> entrySet) {
        ArrayList<Integer> answerList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entrySet) {
            PriorityQueue<Integer> pq = playsMap.get(entry.getKey());
            answerList.add(pq.poll());
            if(pq.isEmpty()) {
                continue;
            }
            answerList.add(pq.poll());
        }
        return answerList;
    }

    private static void fillAllMaps(String[] genres, int[] plays, HashMap<String, PriorityQueue<Integer>> playsMap, HashMap<String, Integer> totalTimeMap) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer play = plays[i];

            PriorityQueue<Integer> pq = playsMap.get(genre);

            if( pq == null) {
                pq = new PriorityQueue<>((o1, o2) -> Integer.compare(plays[o2], plays[o1]));
            }

            pq.offer(i);
            playsMap.put(genre, pq);

            totalTimeMap.put(genre, totalTimeMap.getOrDefault(genre, 0) + play);
        }
    }
}
