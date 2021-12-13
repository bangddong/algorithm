package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_18404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, startX, startY;
    static int[][] dist;
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // 나이트의 이동경로
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 체스판의 크기
        M = Integer.parseInt(st.nextToken()); // 상대편 말의 갯수
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()); // 나이트 x좌표
        startY = Integer.parseInt(st.nextToken()); // 나이트 y좌표

        dist = new int[N + 1][N + 1];
        solution();
    }

    static void solution() throws IOException{
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], -1); // 카운트 및 방문여부 체크를 위한 초기화
        }
        BFS();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); // 상대말 위치
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            sb.append(dist[x][y]).append(' ');
        }
        System.out.println(sb.toString());
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(startX);
        Q.add(startY);
        dist[startX][startY] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue; // 배열 범위 확인
                if (dist[nx][ny] != -1) continue; // 방문여부 확인
                dist[nx][ny] = dist[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
