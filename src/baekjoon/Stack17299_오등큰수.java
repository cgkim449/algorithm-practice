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
 * Date: 2021-12-16
 * Time: 08:21
 * https://www.acmicpc.net/problem/17299
 */
public class Stack17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] counting = new int[1000001]; // 카운팅 배열
        int[] sequence = new int[n]; // 수열 배열
        int[] NGF = new int[n]; // 오등큰수 배열
        Arrays.fill(NGF, -1);

        int i = 0;
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken()); // 수열의 원소
            counting[x]++; // 원소의 개수를 개수 배열에 저장
            sequence[i++] = x; // 원소를 수열 배열에 저장
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < sequence.length; j++) {
            if(stack.isEmpty()) {
                stack.push(j);
                continue;
            }
            while(counting[sequence[stack.peek()]] < counting[sequence[j]]) { // 찾았다
                // 오등큰수저장
                NGF[stack.peek()] = sequence[j];
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
            }

            stack.push(j); // 오등큰수가 아니면 수열 배열의 인덱스 푸쉬
        }

        StringBuilder sb = new StringBuilder();
        for (int ngf : NGF) {
            sb.append(ngf).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
