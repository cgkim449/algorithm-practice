package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Date: 2021-12-14
 * Time: 10:27
 * https://www.acmicpc.net/problem/10799
 */
public class Stack10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int cuts = 0;
        boolean flag = false;
        for (char c : charArray) {
            if (c == '(') {
                if (flag) {
                    flag = false;
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!flag) {
                    cuts += stack.size();
                    flag = true;
                    continue;
                }
                cuts++;
            }
        }
        System.out.println(cuts);
        br.close();
    }
}

/*
 * 단순히 짝을 짓는 문제
 */
