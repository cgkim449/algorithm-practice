package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 13:14
 * https://www.acmicpc.net/problem/13414
 */
public class Hash13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hs = new LinkedHashSet<>();

        while(l-- > 0) {
            String s = br.readLine();
            hs.remove(s);
            hs.add(s);
        }

        for (String h : hs) {
            sb.append(h).append("\n");
            if (--k == 0) break;
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
