package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Date: 2021-12-30
 * Time: 10:42
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */

/*
 * 1. union-find 쓰기 위한 초기화. union-find는 find 메소드를 통해 서로소 집합을 유지한다.
 * 2.1 union: 두 트리를 하나의 트리로 합치는 메서드(간선을 연결함으로써). 단 사이클이 생기면 그 간선은 탈락해야한다(find 메서드 이용)
 *     - union by rank: union의 기법 중 하나. union 후 최악의 경우 깊이가 N이 되는데, 이를 logN으로 줄여준다. 즉, find의 시간복잡도를 O(N)에서 O(logN)으로 줄여줌.
 * 2.2 find: 노드의 루트 노드를 알려주는 메서드(루트 노드가 같다면 사이클이 생긴다는 것이다)
 *     - path compression: find 실행시 동작하는 기법. 루트노드와 나머지 노드의 랭크 차이를 전부 1로 만들어준다. 따라서 find의 시간복잡도를 O(logN)에서 O(1)로 줄여줌
 *                         (물론 union할땐 patch compression이 동작하지 않으므로 맨처음 find는 logN이다.)
 * 3. '모든 노드가 연결되면' 리턴.
 */
public class Greedy42861_섬_연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }

    static HashMap<Integer, Integer> parent = new HashMap<>(); // 모든 노드의 부모 정보(루트 노드의 부모는 자기 자신)
    static HashMap<Integer, Integer> rank = new HashMap<>(); // 모든 노드의 랭크 정보
    
    static public int solution(int n, int[][] costs) {
        int total = 0;

        // 1. union-find 쓰기 위한 초기화
        for (int i = 0; i <= n-1; i++) {
            makeSet(i);
        }

        // 가중치 오름차순
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // 2. 그리디
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                total += cost[2];
            }
        }

        return total;
    }

    static public int find(int node) {
        // path compression 기법
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    static public void union(int nodeV, int nodeU) {
        int root1 = find(nodeV);
        int root2 = find(nodeU);

        // union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) { // 높이가 다를 땐 높이가 큰 쪽에 붙어라
            parent.put(root2, root1);
            // 작은 쪽의 랭크는 딱히 안건드림
        } else {
            parent.put(root1, root2); // 일단 붙이고 랭크 올리자
            if (rank.get(root1) == rank.get(root2)) { // 높이가 같으면 한쪽의 높이를 높이고 거기에 붙여라
                rank.put(root2, rank.get(root2) + 1);
                // 작은 쪽의 랭크는 딱히 안건드림
            }
        }
    }

    static public void makeSet(int node) {
        parent.put(node, node);
        rank.put(node, 0);
    }
}