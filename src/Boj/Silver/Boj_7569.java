package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, H;
    static int[][][] A, dist;
    static int[][] dir = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}}; // N, M, H
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dist = new int[H][N][M];
        A = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    A[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        solution();
    }

    static void solution() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        BFS();
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[i][j][k] == -1) continue; // 벽은 원래 방문하지 못한다.
                    if (dist[i][j][k] == -1) { // 방문하지 못한 칸이 있다 == 다 익지 못한다.
                        answer = -1;
                        System.out.println(answer);
                        return;
                    }
                    answer = Math.max(answer, dist[i][j][k]); // 구해진 최단거리중 제일 큰 값 갱신
                }
            }
        }
        System.out.println(answer);
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        // 토마토의 위치를 담는다.
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[i][j][k] == 1) {
                        Q.add(i);
                        Q.add(j);
                        Q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while(!Q.isEmpty()) {
            int z = Q.poll(), x = Q.poll(), y = Q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue; // 배열범위 초과
                if (dist[nz][nx][ny] != -1) continue; // 이미 방문
                if (A[nz][nx][ny] != 0) continue; // 토마토가 없거나 이미 익은 토마토임
                dist[nz][nx][ny] = dist[z][x][y] + 1;
                Q.add(nz);
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
