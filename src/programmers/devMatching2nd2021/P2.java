package programmers.devMatching2nd2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 1분 시뮬 -> 시간 점프 -> 우선순위큐
 * 출제자의 의도는 시간 점프까지.(우선순위큐는 +알파임)
 * 메뉴 50000개, 주문도 50000개 등 다 큰데 이상하게 화구만 10개다?
 * 시간을 점프할건데 시간을 점프할때 필요한 정보는 화구들 중에서 가장 빨리끝나는 화구의 시간을 알아야한다
 * 그걸 아는 방법은 두가지가 있다 그냥 모든 화구를 하나씩 보면서 최소값 찾기(O(N))
 * 두번째는 화구들마다 언제 끝나는지를 우선순위큐에 넣어놓는것(O(logN))
 * 근데 N이 10밖에 안된다! 그러니 우선순위 큐를 못떠올려도 되는거다 그냥 시간 점프만 생각해내도 통과시켜주자가 의도임
 *
 */

class P2 {// 9개 통과 11개 시간초과
    public static void main(String[] args) {
        int n = 2;
        String[] recipes = {"A 3","B 2"};
        String[] orders = {"A 1","A 2","B 3","B 4"};

        System.out.println(solution(n, recipes, orders));
    }
    static public int solution(int n, String[] recipes, String[] orders) {

        int answer = 0;

        HashMap<String, Integer> recipesMap = new HashMap<>();
        HashMap<Integer, String> ordersMap = new HashMap<>(); // 주문들어온시간
        HashMap<Integer, String> firesMap = new HashMap<>(); // 종료시간

        StringTokenizer st;

        for (String recipe : recipes) {
            st = new StringTokenizer(recipe, " ");
            recipesMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (String order : orders) {
            st = new StringTokenizer(order, " ");
            String o = st.nextToken();
            int t = Integer.parseInt(st.nextToken());
            ordersMap.put(t, o);
        }

        int time = 1;
        loop:
        while(true) {
            // 일단 조리 끝난 애가 있으면 화구에서 빼고 화구 1증가해야됨
            if (firesMap.containsKey(time)) { // 현재 시간에 조리 종료되는 애가 있으면
                // 동시에 끝나는 애들이 잇으니까 반복문 돌려야되며 화구 증가

                ArrayList<Integer> list = new ArrayList<>();
                for (int a : firesMap.keySet()) {
                    if(a == time) {
                        if(firesMap.get(a).equals("LAST")) {
                            answer = time;
                            break loop;
                        }
                        // LAST가 아니면 화구에서 제거하고 n 1증가
                        n++;
                        list.add(a);
                    }
                }
                for (Integer integer : list) {
                    firesMap.remove(integer);
                }
            }

            Set<Integer> subset = new TreeSet<>(ordersMap.keySet()).subSet(0, time + 1);
            if(subset.size() > 0) { // 현재 시간에 넣어야되는 애가 주문서에 있으면
                int z = subset.iterator().next();
                if (n > 0) { // 사용가능 화구가 있으면
                    // 그리고 현재 시간에 넣어야되는 주문이 있으면 화구에 넣는다
                    firesMap.put(time + recipesMap.get(ordersMap.get(z)), ordersMap.size() == 1 ? "LAST" : "NO");
                    // 화구에 넣음. 조리 예상 종료 시간을 key, 마지막인지 아닌지를 value
                    ordersMap.remove(z);
                    // 화구에 넣은 애를 주문서에서 제거
                    n--;
                    // 화구 1개 제거
                    time++;
                    // 시간 1증가
                    continue;
                }
            }
            time++;
        }
        return answer; // 마지막으로 들어온 주문이 완성될 시각
    }
}