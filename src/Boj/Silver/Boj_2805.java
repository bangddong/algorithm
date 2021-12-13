package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    // 1. 주어진 나무를 정렬.
    // 2. lt = 0번 인덱스 숫자, rt = 끝 인덱스 숫자
    // 3. (lt + rt) / 2 의 값으로 나무를 잘라보고
    //    부족하면 lt를 위 값으로, 남으면 rt를 위 값으로 변경
    // 4. M이 나오면 위 값이 정답.
    static void solution() {
        long lt = 0, rt = 2000000000;
        long answer = 0;

        while(lt <= rt) {
            int mid = (int)(lt + rt) / 2;

            long sum = 0;

            for (int i = 1; i <= N; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }

            if (sum >= M) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(answer);
    }
}
