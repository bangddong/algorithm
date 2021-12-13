package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R, C, sheep = 0, wolf = 0;
    static String[] yard;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[R][C];
        yard = new String[R];
        for (int i = 0; i < R; i++) {
            yard[i] = br.readLine();
        }
        solution();
    }

    // DFS 후 늑대와 양의 수를 비교하여 처리하자
    static void solution() {
        int s = 0, w = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j]) continue; // 이미 방문
                if (yard[i].charAt(j) == '#') continue; // 울타리
                sheep = 0;
                wolf = 0;
                DFS(i, j);
                if (sheep > wolf) s += sheep;
                else w += wolf;
            }
        }
        sb.append(s).append(' ').append(w);
        System.out.println(sb);
    }

    // DFS가 돌때마다 해당 영역의 늑대와 양의 수를 반환
    static void DFS(int x, int y) {
        visit[x][y] = true;
        if (yard[x].charAt(y) == 'o') sheep++;
        if (yard[x].charAt(y) == 'v') wolf++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 배열범위 초과
            if (visit[nx][ny]) continue; // 이미 방문
            if (yard[nx].charAt(ny) == '#') continue; // 울타리
            DFS(nx, ny);
        }
    }
}
