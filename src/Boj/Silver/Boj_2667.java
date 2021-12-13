package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, groupCnt;
    static String[] a;
    static boolean[][] visit; // 방문여부
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 방문할 인접 집들 (상, 우, 하, 좌)
    static ArrayList<Integer> group; // 간선정보
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }
        visit = new boolean[N][N];
        solution();
    }

    static void solution() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문한적이 없고 해당 좌표에 집이 있는지?
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    groupCnt = 0;
                    dfs(i, j);
                    group.add(groupCnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (int cnt : group) sb.append(cnt).append('\n');
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        groupCnt++; // 해당 단지 내 집 수 카운트
        visit[x][y] = true; // 방문처리

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || ny >= N || nx >= N) continue; // 배열범위 안인지?
            if(a[nx].charAt(ny) == '0') continue; // 집이 있는지?
            if(visit[nx][ny]) continue; // 방문한적 있는지?
            dfs(nx, ny);
        }
    }
}
