package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R, C;
    static String[] A;
    static int[][] waterDist, hedgeDist;
    static int[][] dir = {{-1, 0}, {0 , 1}, {1, 0}, {0, -1}}; // 물이 갈 수 있는 방향
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        waterDist = new int[R][C]; // 물이 차오르는 거리
        hedgeDist = new int[R][C]; // 고슴도치 이동거리
        A = new String[R];
        for (int i = 0; i < R; i++) A[i] = br.readLine();
        solution();
    }

    static void solution() {
        int answer = 0;
        bfsWater(); // 물을 먼저 채워보자!
        bfsHedgehog(); // 물을 피해 가보자!
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i].charAt(j) == 'D') answer = hedgeDist[i][j];
            }
        }
        System.out.println((answer == -1) ? "KAKTUS" : answer); // 모두 통과할 수 없으면 KAKTUS를 출력한다!
    }

    static void bfsWater() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i].charAt(j) == '*') { // 물의 위치를 큐에 담아두자! (BFS 시작점)
                    waterDist[i][j] = 0; // 방문했다 치자!
                    Q.add(i);
                    Q.add(j);
                } else waterDist[i][j] = -1;
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 배열범위 초과
                if (A[nx].charAt(ny) != '.') continue; // 물은 벽과 굴을 뚫을 수 없다!
                if (waterDist[nx][ny] != -1) continue; // 이미 방문했다
                waterDist[nx][ny] = waterDist[x][y] + 1; // 이동거리 체크
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void bfsHedgehog() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i].charAt(j) == 'S') { // 고슴도치의 위치를 큐에 담아두자! (BFS 시작점)
                    hedgeDist[i][j] = 0; // 방문했다 치자!
                    Q.add(i);
                    Q.add(j);
                } else hedgeDist[i][j] = -1;
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 배열범위 초과
                if (A[nx].charAt(ny) == 'X' || A[nx].charAt(ny) == '*') continue; // 고슴도치는 벽과 물 웅덩이를 뚫을 수 없다!
                if (hedgeDist[nx][ny] != -1) continue; // 이미 방문했다
                if (waterDist[nx][ny] != -1 && hedgeDist[x][y] + 1 >= waterDist[nx][ny]) continue; // 고슴도치가 방문하기 전 물이 차오른다!
                hedgeDist[nx][ny] = hedgeDist[x][y] + 1; // 이동거리 체크
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
