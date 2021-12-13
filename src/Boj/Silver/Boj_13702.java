package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13702 {
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
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }

    // 막걸리 최대 용량 = 2의 31승 - 1로 딱 Integer 범위이나 lt + rt의 경우 범위 넘어갈 수 있음.
    // rt 최대값은 A배열의 최댓값
    static void solution() {
        long lt = 0, rt = 0, answer = 0;
        for (int i = 1; i <= N; i++) rt = Math.max(rt, A[i]);
        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            if (isPossible(mid)) {
                lt = mid + 1;
                answer = mid;
            } else rt = mid - 1;
        }
        System.out.println(answer);
    }

    // 주어진 num으로 A[i]값을 나눈 몫을 sum에 누적
    // sum >= K 일 시 true 반환
    static boolean isPossible(long num) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += A[i] / num;
        }
        return sum >= K;
    }
}
