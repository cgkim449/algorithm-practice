package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-20
 * Time: 19:39
 * https://www.acmicpc.net/problem/14888
 */
public class 응용1_연산자_끼워넣기a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static String numberString;
    static Deque<Integer> numberDeque;
    static ArrayList<Integer> tempArrayList = new ArrayList<>();

    static String operatorString;
    static int[] operatorIntArray = new int[4];
    static int a;
    static int b;
    static int c;
    static int d;

    static int[] selected;
    static int[] used;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        selected = new int[N];
        used = new int[N];

        numberString = br.readLine();
        st = new StringTokenizer(numberString, " ");
        while (st.hasMoreTokens()) {
            tempArrayList.add(Integer.parseInt(st.nextToken()));
        }
        numberDeque = new LinkedList<>(tempArrayList);

        operatorString = br.readLine();
        st = new StringTokenizer(operatorString, " ");
        for (int i = 0; i < operatorIntArray.length; i++) {
            operatorIntArray[i] = Integer.parseInt(st.nextToken());
        }
        a = operatorIntArray[0];
        b = operatorIntArray[1];
        c = operatorIntArray[2];
        d = operatorIntArray[3];
        // a, b, c, d 개
        // 1 ~ a : +
        // a + 1 ~ a + b : -
        // a + b + 1 ~ a + b + c : *
        // a + b + c + 1 ~ N : /
    }

    public static void main(String[] args) throws IOException {
        input();

        recFunc(1);

        sb.append(max).append('\n').append(min);
        output();
    }

    private static void recFunc(int k) {
        if(k == N) {
            Deque<Integer> tempNumberDeque = new LinkedList<>(numberDeque);
            for (int i = 1; i < selected.length; i++) {
                int o = selected[i];
                int x = tempNumberDeque.pollFirst();
                int y = tempNumberDeque.pollFirst();
                if(1<=o && o<=a) {
                    tempNumberDeque.offerFirst(x+y);
                } else if (a+1<=o && o<=a+b){
                    tempNumberDeque.offerFirst(x-y);
                } else if (a+b+1<=o && o<=a+b+c) {
                    tempNumberDeque.offerFirst(x*y);
                } else {
                    tempNumberDeque.offerFirst(x/y);
                }
            }

            int result = tempNumberDeque.poll();
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 1; i <= N-1; i++) {
            if(used[i] == 1) {
                continue;
            }
            selected[k] = i;
            used[i] = 1;
            recFunc(k+1);
            selected[k] = 0;
            used[i] = 0;
        }
    }

    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
 * 퍼뮤테이션 인덱스 조심
 */