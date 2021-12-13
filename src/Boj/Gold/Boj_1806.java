package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, S;
    static int[] A;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();

    }

    static void solution() {
        int rt = 0, sum = 0, answer = N + 1;
        for (int lt = 1; lt <= N; lt++) {
            // 포인터 이동을 위해 좌측 끝 값 마이너스
            sum -= A[lt - 1];
            // 우측 끝에 도달하거나 합이 S보다 커질때 까지 rt 이동
            while (rt + 1 <= N && sum < S) {
                rt++;
                sum += A[rt];
            }
            // 현재까지의 합이 S보다 같거나 크다면 최솟값 갱신
            if (sum >= S) answer = Math.min(answer, rt - lt + 1);
        }
        // 합이 불가능한경우 0을 출력하라는 조건 확인
        if (answer == N + 1) answer = 0;
        System.out.println(answer);
    }
}
