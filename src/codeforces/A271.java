package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-25
 * Time: 01:45
 */
public class A271 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (true){
            n++;
            char[] chars=(String.valueOf(n)).toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            for (char aChar : chars) {
                hashSet.add(aChar);
            }
            if(hashSet.size()==4){
                answer = n;
                break;
            }
        }
        sb.append(answer);
        output();
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
