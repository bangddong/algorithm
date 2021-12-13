package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }

    // 1. N개 만큼의 랜선을 잘라내어야 함.
    // 2. 최소한의 손실로 잘라야 하니 N개를 충족하는 최대 길이로 자른다.
    // 3. 랜선의 길이 최대값으로 이분탐색을 진행하며 11개를 충족하는 길이를 찾아내자.
    static void solution() {
        long lt = 1, rt = Integer.MAX_VALUE, answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (isCut(mid)) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean isCut(long num) {
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / num;
        }
        return sum >= N;
    }
}
