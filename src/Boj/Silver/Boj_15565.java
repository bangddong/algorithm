package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15565 {
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

    // A[lt]가 1일때까지 continue
    // cnt가 K 될때까지 rt++
    // rt - lt + 1을 Math.min
    // answer가 초기값이라면 -1
    static void solution() {
        int rt = 0, cnt = 0, answer = -1;

        for (int lt = 1; lt <= N; lt++) {
            if (A[lt] != 1) continue;
            while(rt + 1 <= N && cnt < K) {
                rt++;
                if (A[rt] == 1) cnt++;
            }
            if (cnt == K) {
                if (answer == -1) answer = rt - lt + 1;
                answer = Math.min(answer, rt - lt + 1);
            }
            if (A[lt] == 1) cnt--;
        }
        System.out.println(answer);
    }
}
