package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        int rt = 0, sum = 0, answer = 0;
        for (int lt = 1; lt <= N; lt++) {
            sum -= A[lt - 1];

            while(rt + 1 <= N && sum < M) {
                rt++;
                sum += A[rt];
            }

            if (sum == M) answer++;
        }
        System.out.println(answer);
    }
}
