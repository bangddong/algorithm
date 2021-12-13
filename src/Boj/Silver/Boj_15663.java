package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] nums, selected, used;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1]; // 선택된 수열
        nums = new int[N + 1]; // 입력 수열
        used = new int[N + 1]; // 사용확인 수열
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 사전 순으로 증가하는 순서로 출력해야 함
        Arrays.sort(nums, 1, N + 1);
        solution(1);
        System.out.println(sb.toString());
    }

    static void solution(int L) {
        // M개의 수열을 다 골랐다면 선택된 숫자 append
        if (L == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int lastNum = 0;
            for (int i = 1; i <= N; i++) {
                if (used[i] == 1) continue; // 사용한 숫자라면 ?
                if (nums[i] == lastNum) continue; // i번째 숫자가 직전에 사용한거라면 ?

                lastNum = nums[i]; // 현재 숫자
                selected[L] = nums[i]; used[i] = 1;
                solution(L + 1);
                selected[L] = 0; used[i] = 0;

            }
        }
    }
}
