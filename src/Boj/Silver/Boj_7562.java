package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N,T, startX, startY, goalX, goalY;
    static int[][] dist;
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // 나이트의 이동경로
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            N = Integer.parseInt(br.readLine());
            dist = new int[N][N];

            st = new StringTokenizer(br.readLine()); // 나이트의 시작 좌표
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); // 나이트의 목적지 좌표
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            solution();
        }
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); // 방문여부 체크를 위한 초기화
        }
        BFS(startX, startY);
        System.out.println(dist[goalX][goalY]); // 정답 출력
    }

    static void BFS(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 0; // 출발지에서는 카운트 하지 않는다

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 배열범위 체크
                if (dist[nx][ny] != -1) continue; // 방문여부 체크
                dist[nx][ny] = dist[x][y] + 1; // 이동횟수 증가
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
