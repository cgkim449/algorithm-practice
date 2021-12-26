package baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-24
 * Time: 17:09
 */
public class B002_바텀업_1_2_3_더하기5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long mod = 1000000009L;
    static int limit = 100000;
    static long[][] d = new long[limit+1][4];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= limit; i++) {
            if(i-1>=0){
                d[i][1] = d[i-1][2]+d[i-1][3];
                if(i==1){
                    d[i][1] = 1;
                }
            }
            if(i-2>=0) {
                d[i][2]=d[i-2][1]+d[i-2][3];
                if(i==2) {
                    d[i][2] = 1;
                }
            }
            if(i-3>=0){
                d[i][3]=d[i-3][1]+d[i-3][2];
                if(i==3){
                    d[i][3]=1;
                }
            }
            d[i][1]%=mod;
            d[i][2]%=mod;
            d[i][3]%=mod;
        }


        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            System.out.println((d[n][1]+d[n][2]+d[n][3])%mod);
        }
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
