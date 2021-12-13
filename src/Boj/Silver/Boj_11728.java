package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11728 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int lt = 1, rt = 1;
        while (lt <= N && rt <= M) {
            int tmp = 0;
            if (A[lt] <= B[rt]) tmp = A[lt++];
            else tmp = B[rt++];
            sb.append(tmp).append(' ');
        }
        while (lt <= N) sb.append(A[lt++]).append(' ');
        while (rt <= M) sb.append(B[rt++]).append(' ');

        System.out.println(sb);
    }
}
