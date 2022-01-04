package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2022-01-04
 * Time: 10:40
 */
public class BruteForce10974_순열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] selected, visited;
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        selected = new int[n+1];
        visited = new int[n+1];

        go(1);
        
        output();
    }

    private static void go(int k) {
        if(k==n+1) {
            for (int i = 1; i < selected.length; i++) {
                int i1 = selected[i];
                sb.append(i1).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= n; cand++) {
                if(visited[cand]==1){
                    continue;
                }
                selected[k] = cand;
                visited[cand]=1;
                go(k+1);
                selected[k] = 0;
                visited[cand]=0;
            }
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
