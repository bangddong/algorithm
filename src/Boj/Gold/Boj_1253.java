package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1253 {
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

    // 1. 배열 정렬
    // 2. 입력 배열에 대해 하나하나 이분탐색 진행
    static void solution() {
        Arrays.sort(A, 1, N + 1);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (isPossible(i)) answer++;
        }
        System.out.println(answer);
    }

    static boolean isPossible(int idx) {
        int lt = 1, rt = N, num = A[idx];
        while (lt < rt) {
            if (lt == idx) lt++;
            else if (rt == idx) rt--;
            else {
                if (A[lt] + A[rt] == num) return true;
                else if (A[lt] + A[rt] > num) rt--;
                else lt++;
            }
        }
        return false;
    }
}
