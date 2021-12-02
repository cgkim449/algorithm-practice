package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by cgkim449
 * Date: 2021-12-02
 * Time: 20:53
 */
public class B18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        loop:
        for (int k = min; k <= max; k++) {
            int testTime = 0;
            int testBlock = b;

            for (int i = 0; i < n; i++) { // 일단 블록을 싹다 모은다
                for (int j = 0; j < m; j++) {
                    int height = map[i][j] - k;
                    if(height > 0) {
                        testBlock += height;
                        testTime += height * 2;
                    }
                }
            }

            for (int i = 0; i < n; i++) { // 일단 블록을 싹다 모은다
                for (int j = 0; j < m; j++) {
                    int height = map[i][j] - k;
                    if(height < 0) {
                        if(Math.abs(height) > testBlock) { // 불가능한 방법이므로 continue loop한다
                            continue loop;
                        }
                        // 블록을 쌓는다
                        testBlock -= Math.abs(height);
                        testTime += Math.abs(height);
                    }
                }
            }

            if(minTime >= testTime) {
                minTime = testTime;
                maxHeight = k;
            }
        }

        System.out.println(minTime + " " + maxHeight);
        br.close();
    }
}
