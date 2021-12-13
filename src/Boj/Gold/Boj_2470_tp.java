package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2470_tp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);

        int maxSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, lt = 1, rt = N;
        while (lt < rt) {
            int sum = A[lt] + A[rt];
            if (Math.abs(sum) < maxSum) {
                maxSum = Math.abs(sum);
                v1 = A[lt];
                v2 = A[rt];
            }
            if (sum > 0) rt --;
            else lt ++;
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb.toString());
    }
}
