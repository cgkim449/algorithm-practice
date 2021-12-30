package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Date: 2021-12-30
 * Time: 10:42
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */

public class Greedy42861_섬_연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }

    static HashMap<String, String> parent = new HashMap<>();
    static HashMap<String, Integer> rank = new HashMap<>();
    
    static public int solution(int n, int[][] costs) {
        int answer = 0;

        ArrayList<String> vertices = new ArrayList<>(); // 노드
        for (int i = 0; i <= n-1; i++) {
            vertices.add(""+i);
        }

        ArrayList<Edge> edges = new ArrayList<>(); // 간선
        for (int[] cost : costs) {
            edges.add(new Edge(cost[2], cost[0] + "", cost[1] + ""));
        }

        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1. 초기화
        for (String vertex : vertices) {
            makeSet(vertex);
        }

        // 2. 간선 weight 기반 sorting
        Collections.sort(edges);

        for (Edge value : edges) {
            currentEdge = value;
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        for (Edge edge : mst) {
            answer += edge.weight;
        }

        return answer;
    }

    static public String find(String node) {
        // path compresion 기법
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    static public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    static public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    static class Edge implements Comparable<Edge> {
        public int weight;
        public String nodeV;
        public String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }
}