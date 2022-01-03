package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[][] A;
    public static void main(String[] args) throws IOException {
        solution();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(A[N][0]).append(' ').append(A[N][1]).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void solution() {
        A = new long[41][2];
        A[0][0] = 1;
        A[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            A[i][0] = A[i - 2][0] + A[i - 1][0];
            A[i][1] = A[i - 2][1] + A[i - 1][1];
        }
    }
}
