package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273_tp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, X;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        solution();
    }

    // 1. 탐색을 위한 정렬
    // 2. A[lt] + A[rt] == X를 향해 반복
    // 3. 이분 탐색처럼 lt가 좌측 끝, rt가 우측 끝에서 이동 시작
    // 4. 수가 크다면 rt --, 수가 적다면 lt ++
    static void solution() {
        Arrays.sort(A, 1, N + 1);
        int lt = 1, rt = N, answer = 0;
        while(lt < rt) {
            int sum = A[lt] + A[rt];
            if (sum > X) rt--;
            else if (sum < X)lt++;
            else {
                answer++;
                lt++;
            }
        }
        System.out.println(answer);
    }
}
