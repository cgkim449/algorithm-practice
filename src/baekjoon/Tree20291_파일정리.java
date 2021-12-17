package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Date: 2021-12-17
 * Time: 18:58
 */
public class Tree20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String haha = st.nextToken();
            treeMap.put(haha, treeMap.getOrDefault(haha, 0)+1);
        }
        for (String s : treeMap.keySet()) {
            sb.append(s).append(" ").append(treeMap.get(s)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
