package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Date: 2022-01-06
 * Time: 12:22
 */
public class Hash9375_패션왕_신해빈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-->0){
            HashMap<String, Integer> hashMap = new HashMap<>();
            int t = Integer.parseInt(br.readLine());
            while (t-->0){
                st = new StringTokenizer(br.readLine());
                String minor = st.nextToken();
                String major = st.nextToken();
                hashMap.put(major, hashMap.getOrDefault(major, 1)+1);
            }
            int total = 1;
            for (String s : hashMap.keySet()) {
                total*=hashMap.get(s);
            }
            sb.append(total-1).append('\n');
        }
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
