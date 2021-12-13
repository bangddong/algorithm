package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int M, N, K;
    static int[][] field; // 배추밭
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 확인해야할 다음 좌표
    static boolean[][] visit; // 방문여부
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추의 갯수

            visit = new boolean[N][M]; // 방문여부
            field = new int[N][M]; // 배추밭
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
                field[x][y] = 1; // 배추위치
            }
            solution();
        }
    }

    static void solution() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] != 1 || visit[i][j]) continue; // 배추가 없거나 이미 방문했는지?
                cnt++; // 배추가 있고 방문한적이 없다면 새 단지
                DFS(i, j);
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 배열범위 안인지?
            if(field[nx][ny] != 1) continue; // 다음 좌표에 배추가 없는지?
            if(visit[nx][ny]) continue; // 다음 좌표를 이미 방문했는지?
            DFS(nx, ny);
        }
    }
}
