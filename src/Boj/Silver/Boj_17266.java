package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17266 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        // N의 높이라면 모든 N을 커버가능하니 최대 범위를 N으로 한다.
        int lt = 0, rt = N, answer = N;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (isPossible(mid)) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        System.out.println(answer);
    }

    static boolean isPossible(int mid) {
        // 마지막으로 비췄던 자리
        int last = 0;
        for (int i = 1; i <= M; i++) {
            if (A[i] - last <= mid) { // 왼쪽을 어디까지 비출 수 있는지?
                last = A[i] + mid; // 오른쪽을 어디까지 비출 수 있는지?
            } else return false;
        }
        return last >= N;
    }
}
