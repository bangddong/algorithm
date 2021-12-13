package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] A, chk;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        chk = new int[100001];
        solution();
    }

    // 1. 1 ~ 100000의 합은 약 60억 == long
    // 2. 탐색의 메모제이션처럼 사용한 숫자 체크하며 전진
    // 3. rt의 위치 == 미사용중인 숫자까지의 위치. 즉 lt ~ rt까지는 다 처음쓰인 숫자
    static void solution() {
        long answer = 0;
        for (int lt = 1, rt = 0; lt <= N; lt++) {
            while(rt + 1 <= N && chk[A[rt + 1]] == 0) {
                rt++;
                chk[A[rt]] = 1;
            }
            answer += rt - lt + 1;
            chk[A[lt]] = 0;
        }
        System.out.println(answer);
    }
}
