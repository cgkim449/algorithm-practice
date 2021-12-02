package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 14:50
 */
public class B16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        while(n-- > 0) {
            String team = br.readLine();
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                String name = br.readLine();
                map.put(name, team);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        while(m-- > 0) {
            String problem = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if(type == 1) {
                sb.append(map.get(problem)).append("\n");
            } else {
                for (String s : map.keySet()) {
                    if(map.get(s).equals(problem)) {
                        pq.offer(s);
                    }
                }
                while(!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
