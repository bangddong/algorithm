package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] selected, checked;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        checked = new int[N + 1];

        searchSequence(1);

        System.out.println(sb.toString());
    }

    static void searchSequence(int L) {
        if (L == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                // 1. 이전에 선택된값이 현재 값보다 크다면 skip
                // 2. 이미 선택된 값이면 skip
                if (selected[L - 1] > i || checked[i] != 0) continue;
                checked[i] = 1;
                selected[L] = i;
                searchSequence(L + 1);
                selected[L] = 0;
                checked[i] = 0;
            }
        }
    }
}
