package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] selected;

    // 1. 1부터 N까지 M개를 중복 허용하여 선택한다.
    // 2. selected라는 int 배열을 사용하여 숫자를 채워나간다.
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        searchSequence(1);

        System.out.println(sb.toString());
    }

    static void searchSequence(int L) {
        // M까지 모두 탐색했다면 선택한 숫자 출력
        if (L == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // N까지 선택하여 재귀호출
            for (int i = 1; i <= N; i++) {
                selected[L] = i;
                searchSequence(L + 1);
                selected[L] = 0;
            }
        }
    }
}
