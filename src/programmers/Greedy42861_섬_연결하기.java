package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Date: 2021-12-30
 * Time: 10:42
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */

/*
 * 1. 초기화
 * 2.1 union : 유니온은 서로소인 부분집합들(트리)을 관리하다가, 가중치 제일 작은(그리디) 간선부터 연결한다. 간선을 연결한다는 것은 두 트리를 하나의 트리로 합친다는것(유니온).
 *      + union by rank(union 방법) : find의 시간복잡도를 O(N)에서 O(logN)으로 줄여줌(logN의 높이를 가지게 되므로. find 할때(루트노드를 찾을 때) 결국 이 높이만큼 체크를 하는 거기때문에.) 최악의 경우는 O(N)이다(트리가 링크드리스트처럼 일렬로 만들어졌을 경우)
 * 2.2 find : 단 사이클이 생기면 그 간선은 탈락. 간선을 연결할 두 노드의 '루트' 노드가 같은지만 판단하면됨. 트리로 관리하기 때문에 루트 노드가 존재하는 것.
 *      + path compression(find 실행시 동작) : find의 시간복잡도를 O(logN)에서 O(1)로 줄여줌(높이를 전부 1차이로 만들어주므로. 물론 맨처음엔 logN이다. 맨처음엔 path compression 안하므로.)
 * 3. 모든 노드가 연결되면 리턴.
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

        // 1. 초기화
        for (int i = 0; i <= n-1; i++) {
            makeSet(i);
        }

        // 가중치 오름차순
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // 2. 그리디
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) { // 간선의 두 노드의 루트 노드가 같지 않으면
                union(cost[0], cost[1]); // 두 노드를 이어줘
                total += cost[2];
            }
        }

        return total;
    }

    static public int find(int node) { // 루트 노드 알려줘
        // path compression 기법
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        // path compression 안쓰는 경우. 걍 재귀만 하면 됨
//        if (parent.get(node) != node) {
//            return find(parent.get(node));
//        }
        return parent.get(node);
    }

    static public void union(int nodeV, int nodeU) { // 두 노드를 이어줘
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