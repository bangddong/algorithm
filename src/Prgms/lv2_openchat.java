package Prgms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lv2_openchat {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int M = 6, N = 4, areaSize = 0, cntSize = 0;
    static int[][] A = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        visit = new boolean[M][N];
        solution();
    }

    static void solution() {
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue; // 방문했다면 가지 않음
                if (A[i][j] == 0) continue; // 색칠되지 않았다면 가지 않음
                cntSize = 0;
                DFS(i, j, A[i][j]);
                maxSize = Math.max(maxSize, cntSize);
                areaSize++;
            }
        }
        int[] answer = new int[2];
        answer[0] = areaSize;
        answer[1] = maxSize;
        System.out.println(Arrays.toString(answer));
    }

    static void DFS(int x, int y, int area) {
        visit[x][y] = true;
        cntSize++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; // 배열범위 초과
            if (visit[nx][ny]) continue;
            if (A[nx][ny] == 0 || A[nx][ny] != area) continue;
            DFS(nx, ny, area);
        }
    }
}
