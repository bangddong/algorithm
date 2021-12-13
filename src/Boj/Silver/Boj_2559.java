package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static int[] A;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        int rt = 0, sum = 0, answer = Integer.MIN_VALUE;

        // lt + K - 1 == K만큼 선택할 수 있는 제일 좌측 수
        for (int lt = 1; lt + K - 1 <= N; lt++) {
            sum -= A[lt - 1];

            while (rt  + 1 <= lt + K - 1) {
                rt++;
                sum += A[rt];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
