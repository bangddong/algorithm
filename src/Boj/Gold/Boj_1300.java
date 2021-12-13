package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        // 배열에 들어있는 수는 i * j이며 N의 최대 범위는 10만, 즉 10만 * 10만이니 long
        long lt = 1, rt = (long) N * N, answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (isPossible(mid)) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        System.out.println(answer);
    }

    // 배열을 그린 후 정렬했을 때 k번째 수는 각 행의 mid보다 작은 숫자의 합이 k인 수 이다.
    static boolean isPossible(long mid) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(mid / i, N);
        }
        return cnt >= K;
    }
}
