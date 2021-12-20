package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 18:39
 */
public class B266 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, t;
    static String s;
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " " );
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        s = br.readLine();
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        char[] charArray = s.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : charArray) {
            arrayList.add(c);
        }
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if(j==arrayList.size()-1) break;
                if(arrayList.get(j) == 'B' && arrayList.get(j+1) == 'G') {
                    Collections.swap(arrayList, j, j+1);
                    j+=1;
                }
            }
        }
        for (Character character : arrayList) {
            sb.append(character);
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
