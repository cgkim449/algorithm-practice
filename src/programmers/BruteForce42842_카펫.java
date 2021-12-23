package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-23
 * Time: 08:44
 */
public class BruteForce42842_카펫 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] case1;
    static int[] case2;
    static int[] case3;

    static int total;
    static int[] counting, selected;
    static int[] answer;

    private static void input() throws IOException {
        case1 = new int[]{10,2};
        case2 = new int[]{8,1};
        case3 = new int[]{24,24};
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(Arrays.toString(solution(case2[0], case2[1])));
        output();
    }


    public static int[] solution(int brown, int yellow) {
        answer = new int[2];
        if(yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        }
        if(yellow == 2) {
            answer[0] = 4;
            answer[1] = 3;
            return answer;
        }

        counting = new int[yellow+1]; // [0,0,3,1,0,0,....]
        selected = new int[yellow+1];

        factorization(yellow); // 24   2 2 2 3

        for (int M = 1; M <= total / 2; M++) {
            recFunc(1, M, brown, yellow);
        }

        return answer;
    }

    private static void recFunc(int k, int M,int brown, int yellow) { // 중복 o, 순서 x
        if(k == M+1) {
            int b = 1;
            for (int i = 1; i <= M; i++) {
                b *= selected[i];
            }
            int a = yellow / b;
            if(brown == a * 2 + b * 2 + 4) {
                answer[0] = Math.max(a,b)+2;
                answer[1] = Math.min(a,b)+2;
            }
        } else {
            int start = selected[k-1];
            if(start == 0) start = 2;
            for (int candidate = start; candidate <= yellow; candidate++) { // 2 2 2 3
                // 2
                // 3
                // 2 2
                // 2 3
                // 3 2
                // 2 2 2
                // 2 2 3
                if(counting[candidate] == 0) {
                    continue;
                }
                selected[k] = candidate;
                counting[candidate]--;
                recFunc(k+1, M, brown, yellow);
                selected[k] = 0;
                counting[candidate]++;
            }
        }
    }

    private static void factorization(int number){
        for (int i = 2; i*i <= number; i++) {
            while (number % i == 0) {
                number /= i;
                counting[i]++;
                total++;
            }
        }
        if(number !=1) {
            counting[number]++;
            total++;
        }
    }


    private static void output() throws IOException {
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
