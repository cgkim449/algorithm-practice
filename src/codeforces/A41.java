package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-22
 * Time: 23:49
 */
public class A41 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    static String s1, s2;
    static Stack<Character> stack;
    private static void input() throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();
        stack = new Stack<>();
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        for (char c : s1.toCharArray())  stack.push(c);
        while (!stack.isEmpty())  sb2.append(stack.pop());
        if(s2.equals(sb2.toString()))  sb.append("YES");
        else sb.append("NO");
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
