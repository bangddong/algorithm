package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Virus {
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, B, answer;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] A, block;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][M + 1];
        block = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }

    static void solution() {
        // 벽 갯수 및 위치 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) {
                    B++;
                    block[B][0] = i;
                    block[B][1] = j;
                }
            }
        }
        // 벽을 세워보자
        DFS(1, 0);
        System.out.println(answer);
    }
    // 벽을 설치 가능한 조합만큼 설치해본다
    static void DFS(int L, int cnt) {
        // 벽을 모두 세웠다!
        if (cnt == 3) {
            BFS();
            return;
        }
        // 더이상 벽을 세울 수 없다.
        if (L > B) return;
        A[block[L][0]][block[L][1]] = 1;
        DFS(L + 1, cnt + 1); // 벽을 세워봤을 경우
        A[block[L][0]][block[L][1]] = 0;
        DFS(L + 1, cnt); // 벽을 세우지 않았을 경우
    }

    // 바이러스를 퍼뜨려본다.
    static void BFS() {
        Queue<Virus> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false; // 방문여부 초기화
                if (A[i][j] == 2) {
                    Q.add(new Virus(i, j));
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()) {
            Virus virus = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = virus.x + dir[k][0];
                int ny = virus.y + dir[k][1];
                if (nx < 0 || ny < 0 || nx > N || ny > M) continue; // 배열범위 초과
                if (visit[nx][ny]) continue; // 바이러스 퍼짐
                if (A[nx][ny] != 0) continue; // 빈 공간이 아님
                visit[nx][ny] = true;
                Q.add(new Virus(nx, ny));
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }
}
