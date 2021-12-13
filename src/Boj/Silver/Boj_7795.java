package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7795 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, M;
    static int[] A,B;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            solution();
        }
    }

    static int lower(int[] A, int L, int R, int x) {
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < x) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static void solution() {
        Arrays.sort(B, 1, M + 1);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += lower(B, 1, M, A[i]);
        }
        System.out.println(answer);
    }
}
