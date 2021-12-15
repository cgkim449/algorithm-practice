package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-15
 * Time: 09:27
 * https://www.acmicpc.net/problem/17298
 */
public class Stack17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        int[] NGEs = new int[n];
        Arrays.fill(NGEs, -1); // 오큰수를 전부 1로 초기화

        int[] sequence = new int[n]; // 수열. 3 5 2 7
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < sequence.length; i++) {
           sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < sequence.length; i++) {
            int a = sequence[i];

            if (stack.isEmpty()) {
                stack.push(i); // 인덱스를 저장한다
                continue;
            }
            while (sequence[stack.peek()] < a) { // a가 오큰수인 애들 찾기
                int index = stack.pop();
                NGEs[index] = a;
                if(stack.isEmpty()) {
                    break;
                }
            }
            stack.push(i);
        }

        for (int i : NGEs) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
 * 스택에 인덱스를 저장
 * 만날때까지 반복문. 만나면 while 문으로 pop.
 */
