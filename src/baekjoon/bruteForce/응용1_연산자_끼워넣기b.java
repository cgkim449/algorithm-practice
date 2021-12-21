package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-21
 * Time: 01:19
 * https://www.acmicpc.net/problem/14888
 */
public class 응용1_연산자_끼워넣기b {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int N, max, min;

    static int[] order;

    static int[] nums;
    static int[] operators;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        operators = new int[5]; // 0, +, -, *, /
        for (int i = 1; i <= 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        order = new int[(N-1)+1];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

    }

    public static void main(String[] args) throws IOException {
        input();

        recFunc(1, nums[1]);

        sb.append(max).append('\n').append(min);
        output();
    }

    private static void recFunc(int k, int value) {
        if(k == (N-1)+1) {
            max = Math.max(value,max);
            min = Math.min(value,min);
            return;
        }
        for (int cand = 1; cand <= 4; cand++) {
            if(operators[cand] == 0) {
                continue;
            }
            order[k] = cand;
            operators[cand]--;
            recFunc(k+1, calculator(k, value, cand));
            order[k] = 0;
            operators[cand]++;
        }
    }

    private static int calculator(int k, int value, int cand) {
        int newValue = value;
        if(cand == 1){
            newValue+=nums[k +1];
        }
        else if(cand == 2){
            newValue-=nums[k +1];
        }
        else if(cand == 3){
            newValue*=nums[k +1];
        }
        else if(cand == 4){
            newValue/=nums[k +1];
        }
        return newValue;
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
 * cand 를 1<= <=4로 줄임
 */