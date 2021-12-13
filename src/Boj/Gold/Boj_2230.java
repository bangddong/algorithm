package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }

    // 1. 이분탐색을 위한 배열 정렬
    // 2. rt - lt가 M 이상인지 확인하여 최솟값 갱신
    // 3. A[i]의 최댓값은 10억, 두 수를 고르니 10억 + 10억이 최댓값. = Integer
    static void solution() {
        Arrays.sort(A, 1, N + 1);
        int rt = 1, answer = Integer.MAX_VALUE;
        for (int lt = 1; lt <= N; lt++) {
            while (rt + 1 <= N && A[rt] - A[lt] < M) {
                rt++;
            }
            if (A[rt] - A[lt] >= M) answer = Math.min(answer, A[rt] - A[lt]);
        }
        System.out.println(answer);
    }
}
