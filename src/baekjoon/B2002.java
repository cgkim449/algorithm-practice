package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 15:13
 */
public class B2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] dArr = new String[n];
        String[] yArr = new String[n];

        for (int i = 0; i < n; i++) dArr[i] = br.readLine();
        for (int i = 0; i < n; i++) yArr[i] = br.readLine();

        int count = 0;

        loop:
        for (String value : dArr) {
            Set<String> set = new HashSet<>();

            for (String s : yArr) {
                if (s.equals(value)) break;
                set.add(s);
            }

            for (String s : dArr) {
                if (s.equals(value))  break;
                if (!set.contains(s)) {
                    count++;
                    continue loop;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
