package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int w, h;
    static int[][] map, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break; // 0, 0이 주어지면 종료
            if (w == 1 && h == 1) { // 1, 1이면 다음 입력값이 곧 정답
                System.out.println(br.readLine());
                continue;
            }
            map = new int[h][w]; // 지도 초기화
            visit = new boolean[h][w]; // 방문여부 초기화
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); // 좌표정보
                }
            }
            solution();
        }
    }

    static void solution() {
        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue; // 이동불가 좌표
            if (visit[nx][ny]) continue; // 이미 방문한 좌표
            if (map[nx][ny] == 0) continue; // 바다
            DFS(nx, ny);
        }
    }
}
