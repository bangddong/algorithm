package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N + 1];
        solution();
    }

    static void solution() {
        for (int i = 1; i <= N; i++) BFS(i);
        System.out.println(sb);
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(visit, false); // 방문기록 초기화
        queue.add(x);

        while(!queue.isEmpty()) {
            x = queue.poll();

            for (int y = 1; y <= N; y++) {
                if(graph[x][y] == 0) continue; // x에서 y로 이동 가능한지 ?
                if(visit[y]) continue; // 이미 탐색했는지?

                queue.add(y);
                visit[y] = true;
            }
        }

        // 문제는 방문 가능한지에 대한 질문이다, 즉 visit이 true인 곳을 출력
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }
}
