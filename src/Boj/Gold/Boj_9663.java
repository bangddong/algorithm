package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, answer;
    static int[] col;

    // 1. N * N 배열에서 N개의 퀸이 공격받지 않도록 놓는다.
    // 2. 퀸은 가로, 세로, 대각선으로 공격 가능하다.
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
        solution(1);
        System.out.println(answer);
    }

    static void solution(int row) {
        // N개만큼 배치가 끝났다면
        if (row == N + 1) {
            // 경우의수를 하나 증가시킨다.
            answer++;
            // 배치가 끝나지 않았다면
        } else {
            // 새로 놓을 자리 탐색 (row, c)
            for (int c = 1; c <= N; c++) {
                boolean isPossible = true;
                // 이전에 놓인 자리 탐색 (i, col[i])
                for (int i = 1; i <= row - 1; i++) {
                    // 이번에 놓을 퀸이 공격받는 자리라면 놓을 수 없다.
                    if (attackable(row, c, i, col[i])) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    col[row] = c;
                    solution(row + 1);
                    col[row] = 0;
                }
            }
        }
    }
    // r1, c1 = 새로 놓을 자리 , r2 = c2 = 이미 놓여져 있는 자리
    static boolean attackable(int r1, int c1, int r2, int c2) {
        // 가로가 같다면
        if(r1 == r2) return true;
        // 세로가 같다면
        if(c1 == c2) return true;
        // 오른쪽 대각선이 같다면
        if(r1 + c1 == r2 + c2) return true;
        // 왼쪽 대각선이 같다면
        return r1 - c1 == r2 - c2;
    }
}
