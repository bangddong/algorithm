package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    // 출력하기 위한 숫자 배열
    static int[] selected;
    // 사용여부를 체크하기 위한 숫자 배열
    static int[] check;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        check = new int[N + 1];

        searchSequence(1);
        System.out.println(sb.toString());
    }

    // 1. 1부터 N까지의 숫자를 중복없이 선택하여 배열에 저장한다.
    // 2. 사용 여부를 체크하기 위해 선택배열에 넣은 숫자는 사용처리 한다.
    // 3. M + 1 까지의 L에 도달하면 선택배열(selected)을 출력한다.
    static void searchSequence(int L) {
        if (L == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    selected[L] = i;
                    searchSequence(L + 1);
                    selected[L] = 0;
                    check[i] = 0;
                }
            }
        }
    }
}
