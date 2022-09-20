package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, result = Integer.MIN_VALUE;
    static int[][] paper;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        paper = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < M; j++) {
                visit[i][j] = true;
                DFS(0, 0, new Location(i, j));
                visit[i][j] = false;
                uncheckedFigure(new Location(i, j));
            }
        }
        System.out.println(result);
    }
    // 갈 수 있는곳은 다 쌓아본다
    static void DFS(int cnt, int sum, Location location) {
        // 4개까지 이어붙일 수 있다
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = location.x + dir[i][0];
            int ny = location.y + dir[i][1];
            // 배열 범위 초과로 쌓을 수 없다.
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            // 이미 쌓여있다.
            if (visit[nx][ny]) continue;
            // 이곳에 쌓았다.
            visit[location.x][location.y] = true;
            DFS(cnt + 1, sum + paper[location.x][location.y], new Location(nx, ny));
            // 다른 스택에서도 쌓아봐야지
            visit[location.x][location.y] = false;
        }
    }

    // 재귀로 체크 불가능한 도형은 따로 체크해준다.
    static void uncheckedFigure(Location location) {
        int x = location.x;
        int y = location.y;
        if (x < N - 2 && y < M - 1)
            result = Math.max(result, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y + 1]);

        if (x < N - 2 && y > 0)
            result = Math.max(result, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y - 1]);

        if (x < N - 1 && y < M - 2)
            result = Math.max(result, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1]);

        if (x > 0 && y < M - 2)
            result = Math.max(result, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x - 1][y + 1]);
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
