package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-03
 * Time: 12:57
 */
public class B16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] ints = new int[10000];

        while (st.hasMoreTokens()) {
            ints[Integer.parseInt(st.nextToken())]++;
        }

        loop:
        while(n-- > 0) {
            for (int j = 1; j <= l; j++) {
                if(ints[j] > 0) {
                    ints[j]--;
                    l++;
                    continue loop;
                }
            }
        }

        System.out.println(l);
        br.close();
    }
}
