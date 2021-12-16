package codeforces.round760;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Date: 2021-12-14
 * Time: 23:13
 */
public class C1618 { // 틀림
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] ints = new int[n];
            int i = 0;
            while (st.hasMoreTokens()) {
                ints[i++] = Integer.parseInt(st.nextToken());
            }

            int number = 0;
            ArrayList<Integer> evenList = new ArrayList<>();

            int number1 = 0;
            ArrayList<Integer> oddList = new ArrayList<>();

            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (j % 2 == 0) {
                    number++;
                    evenList.add(anInt);
                } else {
                    number1++;
                    oddList.add(anInt);
                }
            }

            int[] arr = new int[number];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = evenList.get(j);
            }
            sort(arr, number);

            int min = arr[0], evenGcd;
            for (int j = 1; j < number; j++) {
                if ((arr[j] % min) == 0) {
                } else {
                    min--;
                    j = 0;
                }
            }
            evenGcd = min;

            int[] arr1 = new int[number1];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = oddList.get(j);
            }
            sort(arr1, number1);

            int min1 = arr1[0], oddGcd;
            for (int j = 1; j < number1; j++) {
                if ((arr1[j] % min1) == 0) {
                } else {
                    min1--;
                    j = 0;
                }
            }
            oddGcd = min1;

            int k = evenGcd;
            int sqrt = (int) Math.sqrt(k);
            ArrayList<Integer> evenarr = new ArrayList<>();

            for (int j = 1; j <= sqrt; j++) {
                if (k % j == 0) {
                    evenarr.add(j);
                    if (k / j != j) {
                        evenarr.add(k / j);
                    }
                }
            }
            evenarr.remove(0);

            int l = oddGcd;
            int sqrt1 = (int) Math.sqrt(l);
            ArrayList<Integer> oddarr = new ArrayList<>();

            for (int j = 1; j <= sqrt1; j++) {
                if (l % j == 0) {
                    oddarr.add(j);
                    if (l / j != j) {
                        oddarr.add(l / j);
                    }
                }
            }
            oddarr.remove(0);

            int temp = 0;
            loop:
            for (int h : evenarr) {
                for (int u = 0; u < ints.length; u++) {
                    int v = ints[u];
                    if (u % 2 != 0) {
                        if (v % h == 0) {
                            break loop;
                        }
                    }
                }
                temp = h;
                break;
            }

            if (temp == 0) {
                int temp1 = 0;
                loop:
                for (int h : oddarr) {
                    for (int u = 0; u < ints.length; u++) {
                        int v = ints[u];
                        if (u % 2 == 0) {
                            if (v % h == 0) {
                                break loop;
                            }
                        }
                    }
                    temp1 = h;
                    break;
                }
                if (temp1 == 0) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(temp1).append("\n");
                }
            } else {
                sb.append(temp).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void sort(int arr[], int number) {
        int least, tmp, i ;
        for (i = 0; i < number - 1; i++) {
            least = arr[i];
            for (int j = i + 1; j < number ; j++)
                if (least > arr[j]) {
                    tmp = arr[j];
                    arr[j] = least;
                    least = tmp;
                }
            arr[i] = least;
        }
    }
}
