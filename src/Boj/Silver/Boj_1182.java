package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, S, answer;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solution(1, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }

    static void solution(int L, int sum) {
        // 수열 탐색 완료
        if (L == N + 1) {
            if (sum == S) answer++;
        } else {
            solution(L + 1, sum + nums[L]); // 해당 수열을 선택함
            solution(L + 1, sum); // 해당 수열을 선택하지 않음
        }
    }
}
