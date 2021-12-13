package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[][] dist; // 이동횟수 기록
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 다음 방문좌표
    static String[] A; // input
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][M];

        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        solution();
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); // 배열 초기화
        }
        BFS(0, 0); // (0, 0) 좌표부터 확인하자!
        System.out.println(dist[N - 1][M -1]); // N, M에 도착했을 때 이동 횟수를 출력
    }

    static void BFS(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); // x좌표
        Q.add(y); // y좌표
        dist[x][y] = 1; // 문제에선 시작칸도 체크한다.

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 배열범위 안인지?
                if (A[nx].charAt(ny) == '0') continue; // 방문할 수 있는 칸인지?
                if (dist[nx][ny] != -1) continue; // 이미 방문했는지?
                dist[nx][ny] = dist[x][y] + 1; // 한 칸 전진했으니 이전값 + 1을 한다.
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
