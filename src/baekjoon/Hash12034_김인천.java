package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-17
 * Time: 20:28
 */
public class Hash12034_김인천 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<Long, Long> hm;
        int i = 1;
        while (n-- > 0) {
            hm = new LinkedHashMap<>(100);
            int t = Integer.parseInt(br.readLine())*2;
            st = new StringTokenizer(br.readLine(), " ");
            while (t-- > 0) {
                long p = Long.parseLong(st.nextToken());
                hm.put(p, hm.getOrDefault(p, 0L) + 1);
            }
            sb.append("Case #").append(i++).append(": ");
            for (long p : hm.keySet()) {
                if(hm.get(p) == 0) {
                    continue;
                }
                long q = p * 4 / 3;
                while(hm.get(p) != 0) {
                    hm.put(q, hm.get(q)-1);
                    hm.put(p, hm.get(p)-1);
                    sb.append(p).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
